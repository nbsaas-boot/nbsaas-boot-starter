package com.nbsaas.boot.pay.ext.resource;

import com.github.binarywang.wxpay.bean.entpay.EntPayRequest;
import com.github.binarywang.wxpay.bean.entpay.EntPayResult;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.EntPayService;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.EntPayServiceImpl;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import com.github.binarywang.wxpay.util.XmlConfig;
import com.nbsaas.boot.pay.api.apis.CashConfigApi;
import com.nbsaas.boot.pay.api.apis.CashPaymentApi;
import com.nbsaas.boot.pay.api.apis.PayUserApi;
import com.nbsaas.boot.pay.api.domain.enums.FeeType;
import com.nbsaas.boot.pay.api.domain.enums.SendState;
import com.nbsaas.boot.pay.api.domain.request.CashPaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;
import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;
import com.nbsaas.boot.pay.api.domain.response.CashPaymentResponse;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;
import com.nbsaas.boot.pay.data.entity.CashConfig;
import com.nbsaas.boot.pay.data.entity.PayUser;
import com.nbsaas.boot.pay.ext.apis.CashPaymentExtApi;
import com.nbsaas.boot.pay.ext.domain.request.WithdrawalRequest;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.ext.apis.BasicTradeAccountExtApi;
import com.nbsaas.boot.trade.ext.apis.TradeExtApi;
import com.nbsaas.boot.trade.ext.domain.request.TradeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@Service
public class CashPaymentExtResource implements CashPaymentExtApi {

    @Resource
    private CashPaymentApi cashPaymentApi;

    @Resource
    private PayUserApi payUserApi;

    @Resource
    private TradeExtApi tradeExtApi;

    @Resource
    private CashConfigApi cashConfigApi;

    @Autowired
    private BasicTradeAccountExtApi basicTradeAccountExtApi;


    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public ResponseObject<Long> cashAuto(WithdrawalRequest request) {
        ResponseObject<Long> result=new ResponseObject<>();

        result=cash(request);
        pay(result.getData());


        return result;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public ResponseObject<?> back(CashPaymentDataRequest request) {
        ResponseObject<?> result=new ResponseObject<>();

        CashPaymentResponse payment = cashPaymentApi.oneData(Filter.eq("id", request.getId()));
        if (payment == null) {
            result.setCode(501);
            result.setMsg("无效退款id");
            return result;
        }
        if (payment.getSendState() == SendState.send) {
            result.setCode(502);
            result.setMsg("付款单据不能退款");
            return result;
        }
        if (payment.getSendState() == SendState.back) {
            result.setCode(503);
            result.setMsg("该单据已经退过款了");
            return result;
        }
        if (payment.getOpenId() == null) {
            result.setCode(504);
            result.setMsg("单据openId不存在");
            return result;
        }
        Long account = payment.getTradeAccount();
        if (account == null) {
            result.setCode(505);
            result.setMsg("单据无付款账号");
            return result;
        }

        TradeAccountResponse paymentAccount = basicTradeAccountExtApi.initSpecial("payment");

        TradeRequest cashRequest = new TradeRequest();
        cashRequest.setAmount(payment.getCash());
        cashRequest.setFrom(paymentAccount.getId());
        cashRequest.setTo(account);
        cashRequest.setChangeType(1001);
        cashRequest.setNote("提现退回");
        tradeExtApi.trade(cashRequest);



        CashPaymentDataRequest form=new CashPaymentDataRequest();
        form.setId(payment.getId());
        form.setSendState(SendState.back);
        cashPaymentApi.updateData(form);

        return result;

    }

    public  ResponseObject<Long> cash(WithdrawalRequest request) {
        ResponseObject<Long> result = new ResponseObject<>();
        if (request.getMoney() == null || request.getMoney().compareTo(new BigDecimal(0)) <= 0) {
            result.setCode(-1);
            result.setMsg("无效金额");
            return result;
        }
        PayUserResponse user = payUserApi.oneData(Filter.eq("id", request.getUser()));
        if (user == null) {
            result.setCode(1001);
            result.setMsg("无效token");
            return result;
        }
        if (request.getOpenId() == null) {
            result.setCode(1002);
            result.setMsg("无效微信用户");
            return result;
        }

        if (user.getTradeAccount() == null) {
            user.setTradeAccount(tradeExtApi.initNormal().getId());

            PayUserDataRequest staffForm = new PayUserDataRequest();
            staffForm.setId(user.getId());
            staffForm.setTradeAccount(staffForm.getTradeAccount());
            payUserApi.update(staffForm);
        }
        if (user.getTradeAccountAmount().compareTo(request.getMoney()) < 0) {
            result.setCode(-303);
            result.setMsg("余额不足");
            return result;
        }

        TradeAccountResponse paymentAccount = basicTradeAccountExtApi.initSpecial("payment");

        TradeAccountResponse feeAccount = basicTradeAccountExtApi.initSpecial( "feeAccount");


        CashConfigResponse cashConfig = cashConfigApi.oneData(
                Filter.eq("key", request.getKey()));
        BigDecimal fee = null;
        BigDecimal money = null;
        if (cashConfig == null) {
            result.setCode(503);
            result.setMsg("提现配置没设置");
            return result;
        }

        FeeType feeType = cashConfig.getFeeType();
        if (feeType == null) {
            feeType = FeeType.single;
        }
        if (feeType == FeeType.single) {
            fee = cashConfig.getFee();
        } else {
            BigDecimal rate = cashConfig.getRate();
            if (rate == null) {
                rate = new BigDecimal(0);
            }
            fee = request.getMoney().multiply(rate).divide(new BigDecimal(100));
        }
        if (fee == null) {
            fee = new BigDecimal(0);
        }

        if (fee.compareTo(new BigDecimal(0.001)) > 0) {
            money = request.getMoney().subtract(fee);
            if (money.compareTo(new BigDecimal(0.001)) < 0) {
                result.setCode(-304);
                result.setMsg("手续费大于提现金额");
                return result;
            }

            TradeRequest feeRequest = new TradeRequest();
            feeRequest.setAmount(fee);
            feeRequest.setFrom(user.getTradeAccount());
            feeRequest.setTo(feeAccount.getId());
            feeRequest.setChangeType(3);
            feeRequest.setNote("手续费");
            tradeExtApi.trade(feeRequest);
        }else{
            money=request.getMoney();
        }

        Long userAccount = user.getTradeAccount();
        TradeRequest cashRequest = new TradeRequest();
        cashRequest.setAmount(money);
        cashRequest.setFrom(userAccount);
        cashRequest.setTo(paymentAccount.getId());
        cashRequest.setChangeType(2);
        cashRequest.setNote("微信提现");
        tradeExtApi.trade(cashRequest);

        CashPaymentDataRequest cashPayment = new CashPaymentDataRequest();
        cashPayment.setTradeAccount(userAccount);
        cashPayment.setCashConfig(cashConfig.getId());
        cashPayment.setName(request.getName());
        cashPayment.setMoney(money);
        cashPayment.setSendState(SendState.init);
        cashPayment.setOpenId(request.getOpenId());
        cashPayment.setCashNo(getOrderNo());
        cashPayment.setNote("微信余额提现");
        cashPayment.setFee(fee);
        cashPayment.setCash(request.getMoney());
        cashPayment.setUser(user.getId());
        cashPayment.setPhone(request.getPhone());
        cashPayment.setIdNo(request.getNo());
        cashPayment.setAppId(cashConfig.getAppId());
        cashPayment.setTradeAccount(userAccount);
        CashPaymentResponse res = cashPaymentApi.createData(cashPayment);


        result.setData(res.getId());

        return result;
    }
    private String getOrderNo() {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Random rand=new Random();
        return "TX"+format.format(new Date()) + "" +(rand.nextInt(99999)+10000);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResponseObject<Long> pay(Long id) {
        ResponseObject<Long> result=new ResponseObject<>();

        CashPaymentResponse temp = cashPaymentApi.oneData(Filter.eq("id", id));

        if (temp == null) {
            result.setCode(501);
            result.setMsg("无效信息");
            return result;
        }
        Long cashConfigId = temp.getCashConfig();
        if (cashConfigId == null) {
            result.setCode(502);
            result.setMsg("提现单无配置信息");
            return result;
        }
        CashConfigResponse cashConfig=cashConfigApi.oneData(Filter.eq("id",cashConfigId));
        if (temp.getSendState() == SendState.send) {
            result.setCode(502);
            result.setMsg("该提现单已经支付");
            return result;
        }
        if (temp.getSendState() == SendState.back) {
            result.setCode(503);
            result.setMsg("该提现单已经退回");
            return result;
        }
        if (temp.getSendState() == SendState.fail) {
            result.setCode(504);
            result.setMsg("该提现单无法处理");
            return result;
        }
        XmlConfig.fastMode=true;
        EntPayRequest request = new EntPayRequest();
        request.setAmount(temp.getMoney().multiply(new BigDecimal(100)).intValue());
        request.setPartnerTradeNo(getOrderNo());
        request.setReUserName(temp.getName());
        request.setCheckName("FORCE_CHECK");
        request.setDescription(temp.getNote());
        request.setOpenid(temp.getOpenId());
        request.setSpbillCreateIp("119.23.149.178");

        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(cashConfig.getAppId());
        payConfig.setMchId(cashConfig.getMchId());
        payConfig.setMchKey(cashConfig.getMchKey());
        payConfig.setKeyPath(cashConfig.getKeyPath());
        //payConfig.setSignType("MD5");
        WxPayService wxPayService = new WxPayServiceImpl();
        wxPayService.setConfig(payConfig);
        EntPayService entPayService = new EntPayServiceImpl(wxPayService);
        try {
            EntPayResult entPayResult = entPayService.entPay(request);

            CashPaymentDataRequest cashPaymentDataRequest=new CashPaymentDataRequest();
            cashPaymentDataRequest.setId(temp.getId());
            cashPaymentDataRequest.setSendState(SendState.send);
            cashPaymentDataRequest.setBussNo(entPayResult.getPaymentNo());
            cashPaymentApi.updateData(cashPaymentDataRequest);
        } catch (WxPayException exception) {
            result.setCode(503);
            result.setMsg("付款失败");
            result.setMsg(exception.getErrCodeDes());
            temp.setDemo(exception.getErrCodeDes());
            exception.printStackTrace();
            throw new RuntimeException(exception.getErrCodeDes());
        }
        return result;
    }

}
