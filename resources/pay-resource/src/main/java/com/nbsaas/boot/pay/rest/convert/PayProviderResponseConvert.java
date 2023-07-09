package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayProvider;
import com.nbsaas.boot.pay.api.domain.response.PayProviderResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class PayProviderResponseConvert  implements Converter
<PayProviderResponse,PayProvider> {

@Override
public PayProviderResponse convert(PayProvider source) {
PayProviderResponse  result = new  PayProviderResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getCreator()!=null){
                result.setCreator(source.getCreator().getId());
            }
            if(source.getCreator()!=null){
                result.setCreatorName(source.getCreator().getName());
            }
return result;
}

}

