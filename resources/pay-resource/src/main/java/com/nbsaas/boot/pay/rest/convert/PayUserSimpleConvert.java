package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayUser;
import com.nbsaas.boot.pay.api.domain.simple.PayUserSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class PayUserSimpleConvert implements Converter<PayUserSimple, PayUser> {




@Override
public PayUserSimple convert(PayUser source) {
    PayUserSimple result = new PayUserSimple();

                if(source.getTradeAccount()!=null){
                    result.setTradeAccount(source.getTradeAccount().getId());
                }
                if(source.getTradeAccount()!=null){
                    result.setTradeAccountAmount(source.getTradeAccount().getAmount());
                }
                result.setName(source.getName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}