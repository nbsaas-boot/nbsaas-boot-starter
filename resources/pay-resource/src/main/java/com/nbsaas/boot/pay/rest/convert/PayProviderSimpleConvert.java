package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayProvider;
import com.nbsaas.boot.pay.api.domain.simple.PayProviderSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class PayProviderSimpleConvert implements Converter<PayProviderSimple, PayProvider> {




@Override
public PayProviderSimple convert(PayProvider source) {
    PayProviderSimple result = new PayProviderSimple();

                result.setPlatformMch(source.getPlatformMch());
                result.setNote(source.getNote());
                if(source.getCreator()!=null){
                    result.setCreator(source.getCreator().getId());
                }
                result.setKeyPath(source.getKeyPath());
                result.setName(source.getName());
                if(source.getCreator()!=null){
                    result.setCreatorName(source.getCreator().getName());
                }
                result.setPlatformId(source.getPlatformId());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setKey(source.getKey());
                result.setLastDate(source.getLastDate());


    return result;
}

}