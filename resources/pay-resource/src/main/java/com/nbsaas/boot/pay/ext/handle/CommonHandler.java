package com.nbsaas.boot.pay.ext.handle;

import com.nbsaas.boot.pay.api.apis.PayUserApi;
import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;
import com.nbsaas.boot.pay.ext.apis.PayHandler;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.ext.apis.BasicTradeAccountExtApi;
import com.nbsaas.boot.trade.ext.apis.TradeExtApi;
import com.nbsaas.boot.trade.ext.domain.request.TradeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("commonHandler")
public class CommonHandler implements PayHandler {


    @Autowired
    private BasicTradeAccountExtApi basicTradeAccountExtApi;


    @Autowired
    private TradeExtApi tradeExtApi;

    @Resource
    private PayUserApi payUserApi;

    @Override
    public void pay(PaymentResponse payment) {
        //算账
        TradeAccountResponse paymentAccount = basicTradeAccountExtApi.initSpecial("recharge");
        Long member = payment.getUser();
        if (member == null) {
            return;
        }
        PayUserResponse user = payUserApi.oneData(Filter.eq("id", member));
        if (user==null){
            return;
        }
       Long account= user.getTradeAccount();
        if (account== null) {
            account=tradeExtApi.initNormal().getId();

            PayUserDataRequest userRequest=new PayUserDataRequest();
            userRequest.setId(user.getId());
            userRequest.setTradeAccount(account);
            payUserApi.update(userRequest);
        }
        TradeRequest request = new TradeRequest();
        request.setAmount(payment.getAmount());
        request.setFrom(paymentAccount.getId());
        request.setTo(account);
        request.setChangeType(1);
        request.setNote("充值");
        tradeExtApi.trade(request);
    }
}
