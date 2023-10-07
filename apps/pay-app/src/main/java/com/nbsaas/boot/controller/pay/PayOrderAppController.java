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
import com.nbsaas.boot.pay.api.domain.request.PayOrderDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayOrderSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayOrderResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayOrderSimple;
import com.nbsaas.boot.pay.api.apis.PayOrderApi;
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
@RequestMapping("/app/payOrder")
public class PayOrderAppController {


    @Resource
    private PayOrderApi payOrderApi;


    @RequestMapping("/search")
    public PageResponse<PayOrderSimple> search(PayOrderSearchRequest request) {
        return payOrderApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<PayOrderSimple> list(PayOrderSearchRequest request) {
        return payOrderApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<PayOrderResponse> create(@Validated(AddOperator.class) PayOrderDataRequest request) {
        return payOrderApi.create(request);
    }

     @UpdateData
     @RequestMapping("/update")
     public ResponseObject<PayOrderResponse> update(@Validated(UpdateOperator.class) PayOrderDataRequest
         request) {
         return payOrderApi.update(request);
     }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) PayOrderDataRequest request) {
        return payOrderApi.delete(request);
     }

     @RequestMapping("/view")
     public ResponseObject<PayOrderResponse> view(@Validated(ViewOperator.class) PayOrderDataRequest request) {
         return payOrderApi.view(request);
     }

  }
