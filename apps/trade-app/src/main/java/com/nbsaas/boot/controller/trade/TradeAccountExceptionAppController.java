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
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountExceptionResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountExceptionSimple;
import com.nbsaas.boot.trade.api.apis.TradeAccountExceptionApi;
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
@RequestMapping("/app/tradeAccountException")
public class TradeAccountExceptionAppController {


    @Resource
    private TradeAccountExceptionApi tradeAccountExceptionApi;


    @RequestMapping("/search")
    public PageResponse<TradeAccountExceptionSimple> search(TradeAccountExceptionSearchRequest request) {
        return tradeAccountExceptionApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TradeAccountExceptionSimple> list(TradeAccountExceptionSearchRequest request) {
        return tradeAccountExceptionApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<TradeAccountExceptionResponse> create(@Validated(AddOperator.class) TradeAccountExceptionDataRequest request) {
        return tradeAccountExceptionApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<TradeAccountExceptionResponse> update(@Validated(UpdateOperator.class) TradeAccountExceptionDataRequest
                                                                        request) {
        return tradeAccountExceptionApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TradeAccountExceptionDataRequest request) {
        return tradeAccountExceptionApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<TradeAccountExceptionResponse> view(@Validated(ViewOperator.class) TradeAccountExceptionDataRequest request) {
        return tradeAccountExceptionApi.view(request);
    }

}
