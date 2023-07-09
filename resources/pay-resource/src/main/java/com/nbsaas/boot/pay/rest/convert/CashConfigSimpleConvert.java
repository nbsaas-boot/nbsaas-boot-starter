package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.CashConfig;
import com.nbsaas.boot.pay.api.domain.simple.CashConfigSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class CashConfigSimpleConvert implements Converter<CashConfigSimple, CashConfig> {




@Override
public CashConfigSimple convert(CashConfig source) {
    CashConfigSimple result = new CashConfigSimple();

                result.setNote(source.getNote());
                result.setMchId(source.getMchId());
                result.setMiniMoney(source.getMiniMoney());
                result.setKeyPath(source.getKeyPath());
                result.setFee(source.getFee());
                if(source.getFeeType()!=null){
                    result.setFeeTypeName(String.valueOf(source.getFeeType()));
                }
                result.setFeeType(source.getFeeType());
                result.setAddDate(source.getAddDate());
                result.setMchKey(source.getMchKey());
                result.setRate(source.getRate());
                result.setAppId(source.getAppId());
                result.setName(source.getName());
                result.setId(source.getId());
                result.setKey(source.getKey());
                result.setLastDate(source.getLastDate());


    return result;
}

}