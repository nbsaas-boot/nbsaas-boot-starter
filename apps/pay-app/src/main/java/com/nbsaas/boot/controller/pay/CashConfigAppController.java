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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  前端控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/app/cashConfig")
public class CashConfigAppController {


    @Resource
    private CashConfigApi cashConfigApi;


    @RequestMapping("/search")
    public PageResponse<CashConfigSimple> search(CashConfigSearchRequest request) {
        return cashConfigApi.search(request);
    }

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
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<CashConfigResponse> create(@Validated(AddOperator.class) CashConfigDataRequest request) {
        return cashConfigApi.create(request);
    }

     @UpdateData
     @RequestMapping("/update")
     public ResponseObject<CashConfigResponse> update(@Validated(UpdateOperator.class) CashConfigDataRequest
         request) {
         return cashConfigApi.update(request);
     }

     @RequestMapping("/delete")
     public ResponseObject<?> delete(@Validated(DeleteOperator.class) CashConfigDataRequest request) {
        return cashConfigApi.delete(request);
     }

     @RequestMapping("/view")
     public ResponseObject<CashConfigResponse> view(@Validated(ViewOperator.class) CashConfigDataRequest request) {
         return cashConfigApi.view(request);
     }

  }
