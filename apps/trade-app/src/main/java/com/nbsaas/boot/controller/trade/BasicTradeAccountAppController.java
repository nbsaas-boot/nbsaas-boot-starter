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
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.BasicTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.BasicTradeAccountSimple;
import com.nbsaas.boot.trade.api.apis.BasicTradeAccountApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/app/basicTradeAccount")
public class BasicTradeAccountAppController {


    @Resource
    private BasicTradeAccountApi basicTradeAccountApi;


    @RequestMapping("/search")
    public PageResponse<BasicTradeAccountSimple> search(BasicTradeAccountSearchRequest request) {
        return basicTradeAccountApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<BasicTradeAccountSimple> list(BasicTradeAccountSearchRequest request) {
        return basicTradeAccountApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<BasicTradeAccountResponse> create(@Validated(AddOperator.class) BasicTradeAccountDataRequest request) {
        return basicTradeAccountApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<BasicTradeAccountResponse> update(@Validated(UpdateOperator.class) BasicTradeAccountDataRequest
                                                                    request) {
        return basicTradeAccountApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) BasicTradeAccountDataRequest request) {
        return basicTradeAccountApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<BasicTradeAccountResponse> view(@Validated(ViewOperator.class) BasicTradeAccountDataRequest request) {
        return basicTradeAccountApi.view(request);
    }

}
