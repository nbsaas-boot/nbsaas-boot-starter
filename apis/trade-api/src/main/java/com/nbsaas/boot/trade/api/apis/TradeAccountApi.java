package com.nbsaas.boot.trade.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountSimple;


/**
 * 对外接口
 */
public interface TradeAccountApi extends BaseApi<TradeAccountResponse, TradeAccountSimple, TradeAccountDataRequest> {


}
