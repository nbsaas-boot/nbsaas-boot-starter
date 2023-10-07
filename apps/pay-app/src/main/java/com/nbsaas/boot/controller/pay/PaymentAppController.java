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
import com.nbsaas.boot.pay.api.domain.request.PaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PaymentSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;
import com.nbsaas.boot.pay.api.domain.simple.PaymentSimple;
import com.nbsaas.boot.pay.api.apis.PaymentApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/app/payment")
public class PaymentAppController {


    @Resource
    private PaymentApi paymentApi;


    @RequestMapping("/search")
    public PageResponse<PaymentSimple> search(PaymentSearchRequest request) {
        return paymentApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<PaymentSimple> list(PaymentSearchRequest request) {
        return paymentApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<PaymentResponse> create(@Validated(AddOperator.class) PaymentDataRequest request) {
        return paymentApi.create(request);
    }

     @UpdateData
     @RequestMapping("/update")
     public ResponseObject<PaymentResponse> update(@Validated(UpdateOperator.class) PaymentDataRequest
         request) {
         return paymentApi.update(request);
     }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) PaymentDataRequest request) {
        return paymentApi.delete(request);
     }

     @RequestMapping("/view")
     public ResponseObject<PaymentResponse> view(@Validated(ViewOperator.class) PaymentDataRequest request) {
         return paymentApi.view(request);
     }

  }
