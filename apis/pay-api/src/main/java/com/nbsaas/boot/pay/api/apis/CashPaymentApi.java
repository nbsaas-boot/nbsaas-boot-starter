package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.CashPaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.CashPaymentSimple;
import com.nbsaas.boot.pay.api.domain.response.CashPaymentResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface CashPaymentApi extends BaseApi<CashPaymentResponse, CashPaymentSimple, CashPaymentDataRequest> {


}
