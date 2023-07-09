package com.nbsaas.boot.pay.api.apis;

import com.nbsaas.boot.pay.api.domain.request.TenantAccountDataRequest;
import com.nbsaas.boot.pay.api.domain.simple.TenantAccountSimple;
import com.nbsaas.boot.pay.api.domain.response.TenantAccountResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface TenantAccountApi extends BaseApi<TenantAccountResponse, TenantAccountSimple, TenantAccountDataRequest> {


}
