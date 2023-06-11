package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.TradeAccountException;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountExceptionSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class TradeAccountExceptionSimpleConvert implements Converter<TradeAccountExceptionSimple, TradeAccountException> {




@Override
public TradeAccountExceptionSimple convert(TradeAccountException source) {
    TradeAccountExceptionSimple result = new TradeAccountExceptionSimple();

                result.setAmount(source.getAmount());
                if(source.getAccount()!=null){
                    result.setAccountName(source.getAccount().getName());
                }
                result.setOldAmount(source.getOldAmount());
                result.setCheckValue(source.getCheckValue());
                result.setOldSalt(source.getOldSalt());
                result.setId(source.getId());
                result.setOldCheckValue(source.getOldCheckValue());
                result.setAddDate(source.getAddDate());
                if(source.getAccount()!=null){
                    result.setAccount(source.getAccount().getId());
                }
                result.setLastDate(source.getLastDate());


    return result;
}

}