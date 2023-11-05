package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.apis.ApplicationApi;
import com.nbsaas.boot.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.boot.system.api.domain.request.ApplicationSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/application")
public class ApplicationController {


    @Resource
    private ApplicationApi applicationApi;

    @RequiresPermissions("application")
    @RequestMapping("/search")
    public PageResponse<ApplicationSimple> search(ApplicationSearchRequest request) {
        return applicationApi.search(request);
    }

    @RequiresPermissions("application")
    @RequestMapping("/list")
    public ListResponse<ApplicationSimple> list(ApplicationSearchRequest request) {
        return applicationApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @RequiresPermissions("application")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject
            <ApplicationResponse> create(@Validated(AddOperator.class) ApplicationDataRequest request) {
        return applicationApi.create(request);
    }

    @RequiresPermissions("application")
    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<ApplicationResponse> update(@Validated(UpdateOperator.class) ApplicationDataRequest request) {
        return applicationApi.update(request);
    }

    @RequiresPermissions("application")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ApplicationDataRequest request) {
        return applicationApi.delete(request);
    }

    @RequiresPermissions("application")
    @RequestMapping("/view")
    public ResponseObject<ApplicationResponse> view(@Validated(ViewOperator.class) ApplicationDataRequest request) {
        return applicationApi.view(request);
    }
}