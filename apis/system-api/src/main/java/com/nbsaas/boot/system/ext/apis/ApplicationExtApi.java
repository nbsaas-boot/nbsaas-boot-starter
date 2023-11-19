package com.nbsaas.boot.system.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationResponse;

public interface ApplicationExtApi {

    /**
     * 添加应用
     *
     * @param request
     * @return
     */
    ResponseObject<ApplicationResponse> create(ApplicationDataRequest request);


    /**
     * 修改应用
     * @param request
     * @return
     */
    ResponseObject<ApplicationResponse> update(ApplicationDataRequest request);

}
