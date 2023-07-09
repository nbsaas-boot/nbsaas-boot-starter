package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.PayProviderDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.PayProviderSimple;
import com.nbsaas.boot.pay.api.domain.response.PayProviderResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface PayProviderApi extends BaseApi<PayProviderResponse, PayProviderSimple, PayProviderDataRequest> {


}
