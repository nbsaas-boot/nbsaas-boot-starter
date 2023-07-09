package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.PayConfigDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.PayConfigSimple;
import com.nbsaas.boot.pay.api.domain.response.PayConfigResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface PayConfigApi extends BaseApi<PayConfigResponse, PayConfigSimple, PayConfigDataRequest> {


}
