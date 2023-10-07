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
import com.nbsaas.boot.pay.api.domain.request.PayConfigDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayConfigSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayConfigResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayConfigSimple;
import com.nbsaas.boot.pay.api.apis.PayConfigApi;
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
@RequestMapping("/app/payConfig")
public class PayConfigAppController {


    @Resource
    private PayConfigApi payConfigApi;


    @RequestMapping("/search")
    public PageResponse<PayConfigSimple> search(PayConfigSearchRequest request) {
        return payConfigApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<PayConfigSimple> list(PayConfigSearchRequest request) {
        return payConfigApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<PayConfigResponse> create(@Validated(AddOperator.class) PayConfigDataRequest request) {
        return payConfigApi.create(request);
    }

     @UpdateData
     @RequestMapping("/update")
     public ResponseObject<PayConfigResponse> update(@Validated(UpdateOperator.class) PayConfigDataRequest
         request) {
         return payConfigApi.update(request);
     }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) PayConfigDataRequest request) {
        return payConfigApi.delete(request);
     }

     @RequestMapping("/view")
     public ResponseObject<PayConfigResponse> view(@Validated(ViewOperator.class) PayConfigDataRequest request) {
         return payConfigApi.view(request);
     }

  }
