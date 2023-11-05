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
import com.nbsaas.boot.system.api.domain.request.RoleApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.request.RoleApplicationMenuSearchRequest;
import com.nbsaas.boot.system.api.domain.response.RoleApplicationMenuResponse;
import com.nbsaas.boot.system.api.domain.simple.RoleApplicationMenuSimple;
import com.nbsaas.boot.system.api.apis.RoleApplicationMenuApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/roleApplicationMenu")
public class RoleApplicationMenuController {


    @Resource
    private RoleApplicationMenuApi roleApplicationMenuApi;


    @RequiresPermissions("roleApplicationMenu")
    @RequestMapping("/search")
    public PageResponse <RoleApplicationMenuSimple> search(RoleApplicationMenuSearchRequest request) {
        return roleApplicationMenuApi.search(request);
    }

    @RequiresPermissions("roleApplicationMenu")
    @RequestMapping("/list")
    public ListResponse<RoleApplicationMenuSimple> list(RoleApplicationMenuSearchRequest request) {
        return roleApplicationMenuApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("roleApplicationMenu")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <RoleApplicationMenuResponse> create(@Validated(AddOperator.class) RoleApplicationMenuDataRequest request) {
        return roleApplicationMenuApi.create(request);
    }

   @RequiresPermissions("roleApplicationMenu")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<RoleApplicationMenuResponse> update(@Validated(UpdateOperator.class) RoleApplicationMenuDataRequest request) {
       return roleApplicationMenuApi.update(request);
   }

    @RequiresPermissions("roleApplicationMenu")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) RoleApplicationMenuDataRequest request) {
        return roleApplicationMenuApi.delete(request);
    }

    @RequiresPermissions("roleApplicationMenu")
    @RequestMapping("/view")
    public ResponseObject <RoleApplicationMenuResponse> view(@Validated(ViewOperator.class) RoleApplicationMenuDataRequest  request) {
        return roleApplicationMenuApi.view(request);
    }
}