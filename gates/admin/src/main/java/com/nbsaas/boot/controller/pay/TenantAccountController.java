package com.nbsaas.boot.controller.pay;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.pay.api.domain.request.TenantAccountDataRequest;
import com.nbsaas.boot.pay.api.domain.request.TenantAccountSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.TenantAccountResponse;
import com.nbsaas.boot.pay.api.domain.simple.TenantAccountSimple;
import com.nbsaas.boot.pay.api.apis.TenantAccountApi;
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
@RequestMapping("/tenantAccount")
public class TenantAccountController {


    @Resource
    private TenantAccountApi tenantAccountApi;


    @RequiresPermissions("tenantAccount")
    @RequestMapping("/search")
    public PageResponse <TenantAccountSimple> search(TenantAccountSearchRequest request) {
        return tenantAccountApi.search(request);
    }

    @RequiresPermissions("tenantAccount")
    @RequestMapping("/list")
    public ListResponse<TenantAccountSimple> list(TenantAccountSearchRequest request) {
        return tenantAccountApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("tenantAccount")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TenantAccountResponse> create(@Validated(AddOperator.class) TenantAccountDataRequest request) {
        return tenantAccountApi.create(request);
    }

   @RequiresPermissions("tenantAccount")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TenantAccountResponse> update(@Validated(UpdateOperator.class) TenantAccountDataRequest request) {
       return tenantAccountApi.update(request);
   }

    @RequiresPermissions("tenantAccount")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TenantAccountDataRequest request) {
        return tenantAccountApi.delete(request);
    }

    @RequiresPermissions("tenantAccount")
    @RequestMapping("/view")
    public ResponseObject <TenantAccountResponse> view(@Validated(ViewOperator.class) TenantAccountDataRequest  request) {
        return tenantAccountApi.view(request);
    }
}