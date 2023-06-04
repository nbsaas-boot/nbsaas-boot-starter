package com.nbsaas.boot.system.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.domain.request.DictDataRequest;
import com.nbsaas.boot.system.api.domain.response.DictResponse;

public interface DictExtApi {

    /**
     * 创建字典
     *
     * @param request
     * @return
     */
    ResponseObject<DictResponse> create(DictDataRequest request);
}
