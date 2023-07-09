package com.nbsaas.boot.pay.ext.apis;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;
import com.nbsaas.boot.pay.ext.domain.request.OrderPayRequest;
import com.nbsaas.boot.pay.ext.domain.response.OrderPayResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface PaymentExtApi {

    ResponseObject<PaymentResponse> handle(WxPayOrderNotifyResult notifyResult);


    /**
     * 充值
     *
     * @param request
     * @return
     */
    ResponseObject<OrderPayResponse> recharge(OrderPayRequest request);

}
