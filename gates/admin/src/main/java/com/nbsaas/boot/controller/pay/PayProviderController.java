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
import com.nbsaas.boot.pay.api.domain.request.PayProviderDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayProviderSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayProviderResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayProviderSimple;
import com.nbsaas.boot.pay.api.apis.PayProviderApi;
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
@RequestMapping("/payProvider")
public class PayProviderController {


    @Resource
    private PayProviderApi payProviderApi;


    @RequiresPermissions("payProvider")
    @RequestMapping("/search")
    public PageResponse <PayProviderSimple> search(PayProviderSearchRequest request) {
        return payProviderApi.search(request);
    }

    @RequiresPermissions("payProvider")
    @RequestMapping("/list")
    public ListResponse<PayProviderSimple> list(PayProviderSearchRequest request) {
        return payProviderApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("payProvider")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <PayProviderResponse> create(@Validated(AddOperator.class) PayProviderDataRequest request) {
        return payProviderApi.create(request);
    }

   @RequiresPermissions("payProvider")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<PayProviderResponse> update(@Validated(UpdateOperator.class) PayProviderDataRequest request) {
       return payProviderApi.update(request);
   }

    @RequiresPermissions("payProvider")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) PayProviderDataRequest request) {
        return payProviderApi.delete(request);
    }

    @RequiresPermissions("payProvider")
    @RequestMapping("/view")
    public ResponseObject <PayProviderResponse> view(@Validated(ViewOperator.class) PayProviderDataRequest  request) {
        return payProviderApi.view(request);
    }
}