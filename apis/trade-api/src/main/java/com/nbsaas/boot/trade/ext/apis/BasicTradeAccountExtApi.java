package com.nbsaas.boot.trade.ext.apis;

import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;

public interface BasicTradeAccountExtApi {


    /**
     * 正常账户，余额不能为负数
     * @return
     */
    TradeAccountResponse initNormal(String key);

    /**
     * 特殊账户,余额可以为负数
     * @return
     */
    TradeAccountResponse initSpecial(String key);
}
