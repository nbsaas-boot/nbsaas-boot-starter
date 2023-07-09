package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.PaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.PaymentSimple;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface PaymentApi extends BaseApi<PaymentResponse, PaymentSimple, PaymentDataRequest> {


}
