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
import com.nbsaas.boot.trade.api.domain.request.TradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountSimple;
import com.nbsaas.boot.trade.api.apis.TradeAccountApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/tradeAccount")
public class TradeAccountController {


    @Resource
    private TradeAccountApi tradeAccountApi;


    @RequestMapping("/search")
    public PageResponse<TradeAccountSimple> search(TradeAccountSearchRequest request) {
        return tradeAccountApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TradeAccountSimple> list(TradeAccountSearchRequest request) {
        return tradeAccountApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<TradeAccountResponse> create(@Validated(AddOperator.class) TradeAccountDataRequest request) {
        return tradeAccountApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<TradeAccountResponse> update(@Validated(UpdateOperator.class) TradeAccountDataRequest request) {
        return tradeAccountApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TradeAccountDataRequest request) {
        return tradeAccountApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<TradeAccountResponse> view(@Validated(ViewOperator.class) TradeAccountDataRequest request) {
        return tradeAccountApi.view(request);
    }
}