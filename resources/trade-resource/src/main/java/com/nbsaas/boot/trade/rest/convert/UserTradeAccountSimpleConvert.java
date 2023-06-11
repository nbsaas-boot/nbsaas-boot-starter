package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.UserTradeAccount;
import com.nbsaas.boot.trade.api.domain.simple.UserTradeAccountSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserTradeAccountSimpleConvert implements Converter<UserTradeAccountSimple, UserTradeAccount> {




@Override
public UserTradeAccountSimple convert(UserTradeAccount source) {
    UserTradeAccountSimple result = new UserTradeAccountSimple();

                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setKey(source.getKey());
                result.setLastDate(source.getLastDate());


    return result;
}

}