package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountSimple;
import com.nbsaas.boot.trade.data.entity.TradeAccount;

/**
 * 列表对象转换器
 */

public class TradeAccountSimpleConvert implements Converter<TradeAccountSimple, TradeAccount> {


    @Override
    public TradeAccountSimple convert(TradeAccount source) {
        TradeAccountSimple result = new TradeAccountSimple();

        result.setAmount(source.getAmount());
        result.setSalt(source.getSalt());
        if (source.getAccountType() != null) {
            result.setAccountTypeName(String.valueOf(source.getAccountType()));
        }
        result.setAccountType(source.getAccountType());
        result.setName(source.getName());
        result.setCheckValue(source.getCheckValue());
        result.setId(source.getId());
        result.setAddDate(source.getAddDate());
        result.setSerialNo(source.getSerialNo());
        result.setLastDate(source.getLastDate());


        return result;
    }

}