package com.nbsaas.boot.trade.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.trade.api.domain.request.TradeInfoDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeInfoSimple;


/**
 * 对外接口
 */
public interface TradeInfoApi extends BaseApi<TradeInfoResponse, TradeInfoSimple, TradeInfoDataRequest> {


}
