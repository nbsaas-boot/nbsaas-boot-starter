package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayConfig;
import com.nbsaas.boot.pay.api.domain.simple.PayConfigSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class PayConfigSimpleConvert implements Converter<PayConfigSimple, PayConfig> {




@Override
public PayConfigSimple convert(PayConfig source) {
    PayConfigSimple result = new PayConfigSimple();

                if(source.getPayProvider()!=null){
                    result.setPayProvider(source.getPayProvider().getId());
                }
                result.setNote(source.getNote());
                if(source.getCreator()!=null){
                    result.setCreator(source.getCreator().getId());
                }
                result.setMchId(source.getMchId());
                if(source.getPayProvider()!=null){
                    result.setPayProviderName(source.getPayProvider().getName());
                }
                result.setKeyPath(source.getKeyPath());
                result.setPlatformId(source.getPlatformId());
                result.setAddDate(source.getAddDate());
                result.setMchKey(source.getMchKey());
                if(source.getPayType()!=null){
                    result.setPayTypeName(String.valueOf(source.getPayType()));
                }
                result.setPayType(source.getPayType());
                result.setRate(source.getRate());
                result.setPlatformMchId(source.getPlatformMchId());
                result.setAppId(source.getAppId());
                result.setName(source.getName());
                result.setNotifyUrl(source.getNotifyUrl());
                result.setId(source.getId());
                result.setKey(source.getKey());
                result.setLastDate(source.getLastDate());


    return result;
}

}