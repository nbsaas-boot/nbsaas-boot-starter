package com.nbsaas.boot.pay.ext.apis;

import com.nbsaas.boot.pay.ext.domain.request.PayBack;
import com.nbsaas.boot.pay.ext.domain.request.PayInfo;
import com.nbsaas.boot.pay.ext.domain.request.RefundRequest;
import com.nbsaas.boot.pay.ext.domain.simple.WeiXinPaySimple;

public interface PaymentPlugin {

    PayBack pay(PayInfo payinfo);


    PayBack refund(RefundRequest payinfo);


    WeiXinPaySimple handle(PayBack back);

}