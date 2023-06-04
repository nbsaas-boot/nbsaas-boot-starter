package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.ErrorLogDataRequest;
import com.nbsaas.boot.system.api.domain.response.ErrorLogResponse;
import com.nbsaas.boot.system.api.domain.simple.ErrorLogSimple;


/**
 * 对外接口
 */
public interface ErrorLogApi extends BaseApi<ErrorLogResponse, ErrorLogSimple, ErrorLogDataRequest> {


}
