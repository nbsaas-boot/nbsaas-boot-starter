package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.TradeInfo;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class TradeInfoResponseConvert  implements Converter
<TradeInfoResponse,TradeInfo> {

@Override
public TradeInfoResponse convert(TradeInfo source) {
TradeInfoResponse  result = new  TradeInfoResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getFrom()!=null){
                result.setFrom(source.getFrom().getId());
            }
            if(source.getTo()!=null){
                result.setTo(source.getTo().getId());
            }
return result;
}

}

