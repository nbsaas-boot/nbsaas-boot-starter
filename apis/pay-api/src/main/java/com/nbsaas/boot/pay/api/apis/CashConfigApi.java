package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.CashConfigDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.CashConfigSimple;
import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface CashConfigApi extends BaseApi<CashConfigResponse, CashConfigSimple, CashConfigDataRequest> {


}
