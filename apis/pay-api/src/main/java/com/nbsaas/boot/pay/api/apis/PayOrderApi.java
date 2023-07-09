package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.PayOrderDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.PayOrderSimple;
import com.nbsaas.boot.pay.api.domain.response.PayOrderResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface PayOrderApi extends BaseApi<PayOrderResponse, PayOrderSimple, PayOrderDataRequest> {


}
