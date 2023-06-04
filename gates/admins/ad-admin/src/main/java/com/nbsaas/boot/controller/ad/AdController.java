package com.nbsaas.boot.controller.ad;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.ad.api.apis.AdApi;
import com.nbsaas.boot.ad.api.domain.request.AdDataRequest;
import com.nbsaas.boot.ad.api.domain.request.AdSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/ad")
public class AdController {


    @Resource
    private AdApi adApi;


    @RequestMapping("/search")
    public PageResponse<AdSimple> search(AdSearchRequest request) {
        return adApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<AdSimple> list(AdSearchRequest request) {
        return adApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject
            <AdResponse> create(@Validated(AddOperator.class) AdDataRequest request) {
        return adApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<AdResponse> update(@Validated(UpdateOperator.class) AdDataRequest request) {
        return adApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) AdDataRequest request) {
        return adApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<AdResponse> view(@Validated(ViewOperator.class) AdDataRequest request) {
        return adApi.view(request);
    }
}