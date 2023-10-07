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
import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayUserSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayUserSimple;
import com.nbsaas.boot.pay.api.apis.PayUserApi;
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
@RequestMapping("/app/payUser")
public class PayUserAppController {


    @Resource
    private PayUserApi payUserApi;


    @RequestMapping("/search")
    public PageResponse<PayUserSimple> search(PayUserSearchRequest request) {
        return payUserApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<PayUserSimple> list(PayUserSearchRequest request) {
        return payUserApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<PayUserResponse> create(@Validated(AddOperator.class) PayUserDataRequest request) {
        return payUserApi.create(request);
    }

     @UpdateData
     @RequestMapping("/update")
     public ResponseObject<PayUserResponse> update(@Validated(UpdateOperator.class) PayUserDataRequest
         request) {
         return payUserApi.update(request);
     }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) PayUserDataRequest request) {
        return payUserApi.delete(request);
     }

     @RequestMapping("/view")
     public ResponseObject<PayUserResponse> view(@Validated(ViewOperator.class) PayUserDataRequest request) {
         return payUserApi.view(request);
     }

  }
