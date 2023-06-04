package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserRoleCatalogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserRoleCatalogSimple;
import com.nbsaas.boot.user.api.apis.UserRoleCatalogApi;
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
@RequestMapping("/userRoleCatalog")
public class UserRoleCatalogController {


    @Resource
    private UserRoleCatalogApi userRoleCatalogApi;


    @RequestMapping("/search")
    public PageResponse<UserRoleCatalogSimple> search(UserRoleCatalogSearchRequest request) {
        return userRoleCatalogApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserRoleCatalogSimple> list(UserRoleCatalogSearchRequest request) {
        return userRoleCatalogApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<UserRoleCatalogResponse> create(@Validated(AddOperator.class) UserRoleCatalogDataRequest request) {
        return userRoleCatalogApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<UserRoleCatalogResponse> update(@Validated(UpdateOperator.class) UserRoleCatalogDataRequest request) {
        return userRoleCatalogApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserRoleCatalogDataRequest request) {
        return userRoleCatalogApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<UserRoleCatalogResponse> view(@Validated(ViewOperator.class) UserRoleCatalogDataRequest request) {
        return userRoleCatalogApi.view(request);
    }
}