package com.nbsaas.boot.pay.ext.plugin;

import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.nbsaas.boot.pay.api.apis.PayConfigApi;
import com.nbsaas.boot.pay.api.domain.enums.PayType;
import com.nbsaas.boot.pay.api.domain.response.PayConfigResponse;
import com.nbsaas.boot.pay.ext.apis.PaymentPlugin;
import com.nbsaas.boot.pay.ext.domain.request.PayBack;
import com.nbsaas.boot.pay.ext.domain.request.PayInfo;
import com.nbsaas.boot.pay.ext.domain.request.RefundRequest;
import com.nbsaas.boot.pay.ext.domain.simple.WeiXinPaySimple;
import com.nbsaas.boot.pay.utils.DateUtils;
import com.nbsaas.boot.pay.utils.MapUtils;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;



/**
 * 微信小程序支付.
 */
@Component("weiAppPaymentPlugin")
public class WeiAppPaymentPlugin implements PaymentPlugin {

    @Resource
    private PayConfigApi payConfigApi;

    public static String getNonceStr() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }


    @Override
    public PayBack pay(PayInfo payinfo) {
        PayBack result = new PayBack();
        result.setConfigKey(payinfo.getKey());
        PayConfigResponse pluginConfig = payConfigApi.oneData(Filter.eq("key", payinfo.getKey()));
        if (pluginConfig != null) {
            String appId = pluginConfig.getAppId();
            String mch_id = pluginConfig.getMchId();

            String key = pluginConfig.getMchKey();
            String notify_url = pluginConfig.getNotifyUrl();

            WxPayService wxPayService = new WxPayServiceImpl();
            WxPayConfig payConfig = new WxPayConfig();
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            payConfig.setAppId(appId);
            payConfig.setMchKey(key);
            payConfig.setMchId(mch_id);
            wxPayService.setConfig(payConfig);
            orderRequest.setMchId(mch_id);
                orderRequest.setOpenid(payinfo.getOpenid());
            orderRequest.setNotifyUrl(notify_url);
            orderRequest.setBody(payinfo.getBody());
            orderRequest.setOutTradeNo(getOrderNo());
            orderRequest.setTotalFee(payinfo.getMoney().multiply(new BigDecimal(100)).intValue());
            orderRequest.setTradeType("JSAPI");
            orderRequest.setSpbillCreateIp("123.12.12.123");
            try {
                WxPayUnifiedOrderResult back = wxPayService.unifiedOrder(orderRequest);
                System.out.println(back);
                result.setNo(back.getPrepayId());
                result.setOrderNo(orderRequest.getOutTradeNo());
            } catch (WxPayException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private String getOrderNo() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Random rand=new Random();
        return format.format(new Date()) + "" +(rand.nextInt(99999)+10000);
    }

    public ResponseObject<PayBack> payConfig(PayInfo payinfo) {

        ResponseObject<PayBack> back=new ResponseObject<PayBack>();
        PayBack result = new PayBack();
        back.setData(result);

        if (payinfo.getPayConfigType()==null){
            payinfo.setPayConfigType(PayType.shop);
        }
        String platformId = payinfo.getPlatformId();
        String platformMchId = payinfo.getPlatformMchId();

        String subAppId = payinfo.getSubAppId();
        String sub_mch_id = payinfo.getSubMchId();

        String key = payinfo.getKey();
        String notify_url = payinfo.getNotifyUrl();

        WxPayService wxPayService = new WxPayServiceImpl();
        WxPayConfig payConfig = new WxPayConfig();
        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();

        if (payinfo.getPayConfigType()== PayType.platform) {
            payConfig.setAppId(platformId);
            payConfig.setMchId(platformMchId);

            orderRequest.setSubAppId(subAppId);
            orderRequest.setSubMchId(sub_mch_id);
            orderRequest.setSubOpenid(payinfo.getOpenid());
            orderRequest.setMchId(platformMchId);
        } else {
            payConfig.setAppId(subAppId);
            payConfig.setMchId(sub_mch_id);
            orderRequest.setOpenid(payinfo.getOpenid());
            orderRequest.setMchId(sub_mch_id);
        }
        payConfig.setMchKey(key);
        wxPayService.setConfig(payConfig);



        orderRequest.setNotifyUrl(notify_url);
        orderRequest.setBody(payinfo.getBody());
        orderRequest.setOutTradeNo(getOrderNo());
        orderRequest.setTotalFee(payinfo.getMoney().multiply(new BigDecimal(100)).intValue());
        orderRequest.setTradeType("JSAPI");
        orderRequest.setSpbillCreateIp("123.12.12.123");
        try {
            WxPayUnifiedOrderResult orderResult = wxPayService.unifiedOrder(orderRequest);
            System.out.println(back);
            result.setNo(orderResult.getPrepayId());
            result.setOrderNo(orderRequest.getOutTradeNo());
        } catch (WxPayException e) {
            back.setCode(-301);
            back.setMsg(e.getReturnMsg());
            e.printStackTrace();
        }
        return back;
    }


    @Override
    public PayBack refund(RefundRequest request) {
        PayBack result = new PayBack();
        return result;
    }

    @Override
    public WeiXinPaySimple handle(PayBack back) {
        WeiXinPaySimple result = new WeiXinPaySimple();

        PayConfigResponse pluginConfig = payConfigApi.oneData(Filter.eq("key", back.getConfigKey()));

        if (pluginConfig != null) {
            String appId = pluginConfig.getAppId();
            String mch_id = pluginConfig.getMchId();

            String key = pluginConfig.getKey();
            result.setAppid(appId);
            result.setNoncestr(getNonceStr());
            result.setPackageInfo("prepay_id=" + back.getNo());
            result.setTimestamp("" + DateUtils.second());
            result.setPrepayid(back.getNo());
            result.setPartnerid(mch_id);
            result.setSignType("MD5");

            Map<String, String> map = MapUtils.getSortMap();
            map.put("appId", result.getAppid());
            map.put("package", result.getPackageInfo());
            map.put("nonceStr", result.getNoncestr());
            map.put("timeStamp", result.getTimestamp());
            map.put("signType", result.getSignType());

            String p = MapUtils.params(map);
            p = p + "&key=" + key;
            System.out.println(p);
            String sign = MD5Encode(p);
            result.setSign(sign);
        }
        return result;
    }

    /**
     * MD5编码
     *
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));//正确的写法
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte[] digest) {

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            int val = ((int) digest[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

}
