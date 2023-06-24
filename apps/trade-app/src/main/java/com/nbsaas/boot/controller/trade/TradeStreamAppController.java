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
import com.nbsaas.boot.trade.api.domain.request.TradeStreamDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeStreamSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeStreamResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeStreamSimple;
import com.nbsaas.boot.trade.api.apis.TradeStreamApi;
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
@RequestMapping("/app/tradeStream")
public class TradeStreamAppController {


    @Resource
    private TradeStreamApi tradeStreamApi;


    @RequestMapping("/search")
    public PageResponse<TradeStreamSimple> search(TradeStreamSearchRequest request) {
        return tradeStreamApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TradeStreamSimple> list(TradeStreamSearchRequest request) {
        return tradeStreamApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<TradeStreamResponse> create(@Validated(AddOperator.class) TradeStreamDataRequest request) {
        return tradeStreamApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<TradeStreamResponse> update(@Validated(UpdateOperator.class) TradeStreamDataRequest
                                                              request) {
        return tradeStreamApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TradeStreamDataRequest request) {
        return tradeStreamApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<TradeStreamResponse> view(@Validated(ViewOperator.class) TradeStreamDataRequest request) {
        return tradeStreamApi.view(request);
    }

}
