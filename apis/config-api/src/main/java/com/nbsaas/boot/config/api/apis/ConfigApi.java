package com.nbsaas.boot.config.api.apis;

import com.nbsaas.boot.config.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.config.api.domain.simple.ConfigSimple;
import com.nbsaas.boot.config.api.domain.response.ConfigResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ConfigApi extends BaseApi<ConfigResponse, ConfigSimple, ConfigDataRequest> {


}
