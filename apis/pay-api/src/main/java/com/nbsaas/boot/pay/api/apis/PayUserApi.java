package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.PayUserSimple;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface PayUserApi extends BaseApi<PayUserResponse, PayUserSimple, PayUserDataRequest> {


}
