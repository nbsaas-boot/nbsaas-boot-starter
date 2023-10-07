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
import com.nbsaas.boot.pay.api.domain.request.CashConfigDataRequest;
import com.nbsaas.boot.pay.api.domain.request.CashConfigSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;
import com.nbsaas.boot.pay.api.domain.simple.CashConfigSimple;
import com.nbsaas.boot.pay.api.apis.CashConfigApi;
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
@RequestMapping("/cashConfig")
public class CashConfigController {


    @Resource
    private CashConfigApi cashConfigApi;


    @RequiresPermissions("cashConfig")
    @RequestMapping("/search")
    public PageResponse <CashConfigSimple> search(CashConfigSearchRequest request) {
        return cashConfigApi.search(request);
    }

    @RequiresPermissions("cashConfig")
    @RequestMapping("/list")
    public ListResponse<CashConfigSimple> list(CashConfigSearchRequest request) {
        return cashConfigApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("cashConfig")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <CashConfigResponse> create(@Validated(AddOperator.class) CashConfigDataRequest request) {
        return cashConfigApi.create(request);
    }

   @RequiresPermissions("cashConfig")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<CashConfigResponse> update(@Validated(UpdateOperator.class) CashConfigDataRequest request) {
       return cashConfigApi.update(request);
   }

    @RequiresPermissions("cashConfig")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) CashConfigDataRequest request) {
        return cashConfigApi.delete(request);
    }

    @RequiresPermissions("cashConfig")
    @RequestMapping("/view")
    public ResponseObject <CashConfigResponse> view(@Validated(ViewOperator.class) CashConfigDataRequest  request) {
        return cashConfigApi.view(request);
    }
}