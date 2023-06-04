package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.system.api.domain.request.DictItemDataRequest;
import com.nbsaas.boot.system.api.domain.request.DictItemSearchRequest;
import com.nbsaas.boot.system.api.domain.response.DictItemResponse;
import com.nbsaas.boot.system.api.domain.simple.DictItemSimple;
import com.nbsaas.boot.system.api.apis.DictItemApi;
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
@RequestMapping("/dictItem")
public class DictItemController {


    @Resource
    private DictItemApi dictItemApi;


    @RequestMapping("/search")
    public PageResponse<DictItemSimple> search(DictItemSearchRequest request) {
        return dictItemApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<DictItemSimple> list(DictItemSearchRequest request) {
        return dictItemApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<DictItemResponse> create(@Validated(AddOperator.class) DictItemDataRequest request) {
        return dictItemApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<DictItemResponse> update(@Validated(UpdateOperator.class) DictItemDataRequest request) {
        return dictItemApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) DictItemDataRequest request) {
        return dictItemApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<DictItemResponse> view(@Validated(ViewOperator.class) DictItemDataRequest request) {
        return dictItemApi.view(request);
    }
}