package com.nbsaas.boot.pay.ext.resource;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.nbsaas.boot.pay.api.apis.PayConfigApi;
import com.nbsaas.boot.pay.api.domain.enums.PayState;
import com.nbsaas.boot.pay.api.domain.response.PayConfigResponse;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;
import com.nbsaas.boot.pay.data.entity.PayConfig;
import com.nbsaas.boot.pay.data.entity.PayUser;
import com.nbsaas.boot.pay.data.entity.Payment;
import com.nbsaas.boot.pay.data.repository.PaymentRepository;
import com.nbsaas.boot.pay.ext.apis.PayHandler;
import com.nbsaas.boot.pay.ext.apis.PaymentExtApi;
import com.nbsaas.boot.pay.ext.domain.request.OrderPayRequest;
import com.nbsaas.boot.pay.ext.domain.request.PayBack;
import com.nbsaas.boot.pay.ext.domain.request.PayInfo;
import com.nbsaas.boot.pay.ext.domain.response.OrderPayResponse;
import com.nbsaas.boot.pay.ext.domain.simple.WeiXinPaySimple;
import com.nbsaas.boot.pay.ext.plugin.WeiAppPaymentPlugin;
import com.nbsaas.boot.pay.rest.convert.PaymentResponseConvert;
import com.nbsaas.boot.pay.utils.DateUtils;
import com.nbsaas.boot.pay.utils.MapUtils;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.nbsaas.boot.pay.ext.plugin.WeiAppPaymentPlugin.MD5Encode;
import static com.nbsaas.boot.pay.ext.plugin.WeiAppPaymentPlugin.getNonceStr;


@Service
public class PaymentExtResource implements PaymentExtApi {

    @Resource
    private PaymentRepository paymentRepository;

    @Resource
    private PayConfigApi payConfigApi;

    @Resource
    private Map<String, PayHandler> payHandleMap = new HashMap<>();

    @Transactional
    @Override
    public ResponseObject<PaymentResponse> handle(WxPayOrderNotifyResult notifyResult) {
        ResponseObject<PaymentResponse> result=new ResponseObject<PaymentResponse>();

        Payment payment = paymentRepository.findByPayNo(notifyResult.getOutTradeNo());
        if (payment != null) {
            if (payment.getPayState() == PayState.wait) {
                payment.setPayState(PayState.success);
                payment.setBussNo(notifyResult.getTransactionId());
                payment.setPaymentDate(new Date());
                if (payment.getHandle() != null) {
                    PayHandler payHandle = payHandleMap.get(payment.getHandle());
                    if (payHandle != null) {
                        try {
                            System.out.println(":" + payHandle.getClass().getSimpleName());
                            PaymentResponse response = new PaymentResponseConvert().apply(payment);
                            payHandle.pay(response);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("无效支付处理器");
                    }
                }
            }
        }
        return result;
    }

    @Transactional
    @Override
    public ResponseObject<OrderPayResponse> recharge(OrderPayRequest request) {
        ResponseObject<OrderPayResponse> result=new ResponseObject<>();
        PayInfo payinfo = new PayInfo();
        if (!StringUtils.hasText(request.getOpenId())) {
            result.setCode(503);
            result.setMsg("没有通过小程序登陆");
            return result;
        }
        if (!StringUtils.hasText(request.getKey())) {
            result.setCode(503);
            result.setMsg("支付方式不存在");
            return result;
        }

        PayConfigResponse temp = payConfigApi.oneData( Filter.eq("key", request.getKey()));
        if (temp == null) {
            result.setCode(504);
            result.setMsg("支付方式不存在");
            return result;
        }

        payinfo.setOpenid(request.getOpenId());
        payinfo.setMoney(request.getMoney());
        payinfo.setPayType(request.getPayType());
        payinfo.setBody("充值");
        payinfo.setSubAppId(temp.getAppId());
        payinfo.setSubMchId(temp.getMchId());
        payinfo.setPayConfigType(temp.getPayType());
        payinfo.setPlatformId(temp.getPlatformId());
        payinfo.setPlatformMchId(temp.getPlatformMchId());
        payinfo.setKey(temp.getMchKey());
        payinfo.setNotifyUrl(temp.getNotifyUrl());


        WeiAppPaymentPlugin paymentPlugin = new WeiAppPaymentPlugin();
        ResponseObject<PayBack> payBack = paymentPlugin.payConfig(payinfo);
        if (payBack.getCode() != 200) {
            result.setCode(payBack.getCode());
            result.setMsg(payBack.getMsg());
            return result;
        }
        PayBack back=payBack.getData();
        String appId = temp.getAppId();
        String key = temp.getMchKey();

        WeiXinPaySimple paySimple = new WeiXinPaySimple();
        paySimple.setAppid(appId);
        paySimple.setNoncestr(getNonceStr());
        paySimple.setPackageInfo("prepay_id=" + back.getNo());
        paySimple.setTimestamp("" + DateUtils.second());
        paySimple.setPrepayid(back.getNo());
        paySimple.setSignType("MD5");

        Map<String, String> map = MapUtils.getSortMap();
        map.put("appId", paySimple.getAppid());
        map.put("package", paySimple.getPackageInfo());
        map.put("nonceStr", paySimple.getNoncestr());
        map.put("timeStamp", paySimple.getTimestamp());
        map.put("signType", paySimple.getSignType());

        String p = MapUtils.params(map);
        p = p + "&key=" + key;
        System.out.println(p);
        String sign = MD5Encode(p);
        paySimple.setSign(sign);


        String no = back.getNo();

        if (request.getPayHandler()==null){
            request.setPayHandler("commonHandler");
        }
        Payment payment = new Payment();
        payment.setPayNo(back.getOrderNo());
        payment.setAmount(request.getMoney());
        payment.setUser(PayUser.fromId(request.getUser()));
        payment.setPayState(PayState.wait);
        payment.setHandle(request.getPayHandler());
        payment.setBussId(request.getDataId());

        PayConfig payConfig=new PayConfig();
        payConfig.setId(temp.getId());
        payment.setPayConfig(payConfig);
        paymentRepository.save(payment);


        OrderPayResponse data=new OrderPayResponse();
        result.setData(data);

        data.setNo(no);
        data.setPay(paySimple);
        return result;
    }
}
