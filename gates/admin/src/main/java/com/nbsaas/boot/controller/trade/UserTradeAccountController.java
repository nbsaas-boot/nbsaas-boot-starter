package com.nbsaas.boot.controller.trade;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.UserTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.UserTradeAccountSimple;
import com.nbsaas.boot.trade.api.apis.UserTradeAccountApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/userTradeAccount")
public class UserTradeAccountController {


    @Resource
    private UserTradeAccountApi userTradeAccountApi;


    @RequestMapping("/search")
    public PageResponse <UserTradeAccountSimple> search(UserTradeAccountSearchRequest request) {
        return userTradeAccountApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserTradeAccountSimple> list(UserTradeAccountSearchRequest request) {
        return userTradeAccountApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <UserTradeAccountResponse> create(@Validated(AddOperator.class) UserTradeAccountDataRequest request) {
        return userTradeAccountApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<UserTradeAccountResponse> update(@Validated(UpdateOperator.class) UserTradeAccountDataRequest request) {
       return userTradeAccountApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserTradeAccountDataRequest request) {
        return userTradeAccountApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <UserTradeAccountResponse> view(@Validated(ViewOperator.class) UserTradeAccountDataRequest  request) {
        return userTradeAccountApi.view(request);
    }
}