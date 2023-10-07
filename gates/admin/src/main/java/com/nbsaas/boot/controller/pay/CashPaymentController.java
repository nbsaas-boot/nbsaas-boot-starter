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
import com.nbsaas.boot.pay.api.domain.request.CashPaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.request.CashPaymentSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.CashPaymentResponse;
import com.nbsaas.boot.pay.api.domain.simple.CashPaymentSimple;
import com.nbsaas.boot.pay.api.apis.CashPaymentApi;
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
@RequestMapping("/cashPayment")
public class CashPaymentController {


    @Resource
    private CashPaymentApi cashPaymentApi;


    @RequiresPermissions("cashPayment")
    @RequestMapping("/search")
    public PageResponse <CashPaymentSimple> search(CashPaymentSearchRequest request) {
        return cashPaymentApi.search(request);
    }

    @RequiresPermissions("cashPayment")
    @RequestMapping("/list")
    public ListResponse<CashPaymentSimple> list(CashPaymentSearchRequest request) {
        return cashPaymentApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("cashPayment")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <CashPaymentResponse> create(@Validated(AddOperator.class) CashPaymentDataRequest request) {
        return cashPaymentApi.create(request);
    }

   @RequiresPermissions("cashPayment")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<CashPaymentResponse> update(@Validated(UpdateOperator.class) CashPaymentDataRequest request) {
       return cashPaymentApi.update(request);
   }

    @RequiresPermissions("cashPayment")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) CashPaymentDataRequest request) {
        return cashPaymentApi.delete(request);
    }

    @RequiresPermissions("cashPayment")
    @RequestMapping("/view")
    public ResponseObject <CashPaymentResponse> view(@Validated(ViewOperator.class) CashPaymentDataRequest  request) {
        return cashPaymentApi.view(request);
    }
}