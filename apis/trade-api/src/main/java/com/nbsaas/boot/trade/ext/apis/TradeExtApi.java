package com.nbsaas.boot.trade.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;
import com.nbsaas.boot.trade.ext.domain.request.TradeRequest;

public interface TradeExtApi {

    /**
     * 正常账户，余额不能为负数
     *
     * @return
     */
    TradeAccountResponse initNormal();

    /**
     * 特殊账户,余额可以为负数
     *
     * @return
     */
    TradeAccountResponse initSpecial();


    ResponseObject<TradeInfoResponse> trade(TradeRequest request);
}
