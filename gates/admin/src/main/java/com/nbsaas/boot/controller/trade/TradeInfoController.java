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
import com.nbsaas.boot.trade.api.domain.request.TradeInfoDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeInfoSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeInfoSimple;
import com.nbsaas.boot.trade.api.apis.TradeInfoApi;
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
@RequestMapping("/tradeInfo")
public class TradeInfoController {


    @Resource
    private TradeInfoApi tradeInfoApi;


    @RequestMapping("/search")
    public PageResponse <TradeInfoSimple> search(TradeInfoSearchRequest request) {
        return tradeInfoApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<TradeInfoSimple> list(TradeInfoSearchRequest request) {
        return tradeInfoApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TradeInfoResponse> create(@Validated(AddOperator.class) TradeInfoDataRequest request) {
        return tradeInfoApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TradeInfoResponse> update(@Validated(UpdateOperator.class) TradeInfoDataRequest request) {
       return tradeInfoApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TradeInfoDataRequest request) {
        return tradeInfoApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <TradeInfoResponse> view(@Validated(ViewOperator.class) TradeInfoDataRequest  request) {
        return tradeInfoApi.view(request);
    }
}