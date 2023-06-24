package com.nbsaas.boot.controller.config;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.config.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.config.api.domain.request.ConfigSearchRequest;
import com.nbsaas.boot.config.api.domain.response.ConfigResponse;
import com.nbsaas.boot.config.api.domain.simple.ConfigSimple;
import com.nbsaas.boot.config.api.apis.ConfigApi;
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
@RequestMapping("/app/config")
public class ConfigAppController {


    @Resource
    private ConfigApi configApi;


    @RequestMapping("/search")
    public PageResponse<ConfigSimple> search(ConfigSearchRequest request) {
        return configApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ConfigSimple> list(ConfigSearchRequest request) {
        return configApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ConfigResponse> create(@Validated(AddOperator.class) ConfigDataRequest request) {
        return configApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<ConfigResponse> update(@Validated(UpdateOperator.class) ConfigDataRequest
                                                         request) {
        return configApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ConfigDataRequest request) {
        return configApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ConfigResponse> view(@Validated(ViewOperator.class) ConfigDataRequest request) {
        return configApi.view(request);
    }

}
