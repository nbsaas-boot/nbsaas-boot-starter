package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 实体对象转化成响应对象
 */

public class TradeAccountResponseConvert implements Converter
        <TradeAccountResponse, TradeAccount> {

    @Override
    public TradeAccountResponse convert(TradeAccount source) {
        TradeAccountResponse result = new TradeAccountResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getAccountType() != null) {
            result.setAccountTypeName(String.valueOf(source.getAccountType()));
        }
        return result;
    }

}

