package com.nbsaas.boot.controller.ad;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.ad.api.domain.request.AdPositionDataRequest;
import com.nbsaas.boot.ad.api.domain.request.AdPositionSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.boot.ad.api.apis.AdPositionApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/app/adPosition")
public class AdPositionAppController {


    @Resource
    private AdPositionApi adPositionApi;


    @RequestMapping("/search")
    public PageResponse<AdPositionSimple> search(AdPositionSearchRequest request) {
        return adPositionApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<AdPositionSimple> list(AdPositionSearchRequest request) {
        return adPositionApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<AdPositionResponse> create(@Validated(AddOperator.class) AdPositionDataRequest request) {
        return adPositionApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<AdPositionResponse> update(@Validated(UpdateOperator.class) AdPositionDataRequest
                                                             request) {
        return adPositionApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) AdPositionDataRequest request) {
        return adPositionApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<AdPositionResponse> view(@Validated(ViewOperator.class) AdPositionDataRequest request) {
        return adPositionApi.view(request);
    }

}
