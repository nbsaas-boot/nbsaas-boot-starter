package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.BasicTradeAccount;
import com.nbsaas.boot.trade.api.domain.simple.BasicTradeAccountSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class BasicTradeAccountSimpleConvert implements Converter<BasicTradeAccountSimple, BasicTradeAccount> {




@Override
public BasicTradeAccountSimple convert(BasicTradeAccount source) {
    BasicTradeAccountSimple result = new BasicTradeAccountSimple();

                if(source.getAccount()!=null){
                    result.setAccountName(source.getAccount().getName());
                }
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setKey(source.getKey());
                if(source.getAccount()!=null){
                    result.setAccount(source.getAccount().getId());
                }
                result.setLastDate(source.getLastDate());


    return result;
}

}