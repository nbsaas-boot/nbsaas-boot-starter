package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.MockDataRequest;
import com.nbsaas.boot.system.api.domain.response.MockResponse;
import com.nbsaas.boot.system.api.domain.simple.MockSimple;


/**
 * 对外接口
 */
public interface MockApi extends BaseApi<MockResponse, MockSimple, MockDataRequest> {


}
