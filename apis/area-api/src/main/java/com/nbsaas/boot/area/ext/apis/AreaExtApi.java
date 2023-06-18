package com.nbsaas.boot.area.ext.apis;

import com.nbsaas.boot.area.ext.domain.request.PoiSearchRequest;
import com.nbsaas.boot.area.ext.domain.response.PoiResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface AreaExtApi {

    /**
     * 根据地址搜索对应的地址信息
     *
     * @param request
     * @return
     */
    ResponseObject<PoiResponse> search(PoiSearchRequest request);

}
