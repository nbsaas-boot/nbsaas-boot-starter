package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.TradeStream;
import com.nbsaas.boot.trade.api.domain.response.TradeStreamResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class TradeStreamResponseConvert  implements Converter
<TradeStreamResponse,TradeStream> {

@Override
public TradeStreamResponse convert(TradeStream source) {
TradeStreamResponse  result = new  TradeStreamResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getAccount()!=null){
                result.setAccount(source.getAccount().getId());
            }
            if(source.getInfo()!=null){
                result.setInfo(source.getInfo().getId());
            }
return result;
}

}

