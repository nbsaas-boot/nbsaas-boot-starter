package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.TradeStream;
import com.nbsaas.boot.trade.api.domain.simple.TradeStreamSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class TradeStreamSimpleConvert implements Converter
<TradeStreamSimple, TradeStream> {




@Override
public TradeStreamSimple convert(TradeStream source) {
TradeStreamSimple result = new TradeStreamSimple();

            result.setPreAmount(source.getPreAmount());
            result.setNote(source.getNote());
            result.setAmount(source.getAmount());
            result.setChangeType(source.getChangeType());
            result.setId(source.getId());
            result.setAfterAmount(source.getAfterAmount());
            result.setAddDate(source.getAddDate());
            if(source.getAccount()!=null){
                result.setAccount(source.getAccount().getId());
            }
            result.setSerialNo(source.getSerialNo());
            if(source.getInfo()!=null){
                result.setInfo(source.getInfo().getId());
            }
            result.setLastDate(source.getLastDate());


return result;
}

}