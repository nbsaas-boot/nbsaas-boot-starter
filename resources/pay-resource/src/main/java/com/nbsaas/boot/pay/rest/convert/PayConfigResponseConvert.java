package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayConfig;
import com.nbsaas.boot.pay.api.domain.response.PayConfigResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class PayConfigResponseConvert  implements Converter<PayConfigResponse,PayConfig> {

    @Override
    public PayConfigResponse convert(PayConfig source) {
        PayConfigResponse  result = new  PayConfigResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getPayProvider()!=null){
                        result.setPayProvider(source.getPayProvider().getId());
                    }
                    if(source.getCreator()!=null){
                        result.setCreator(source.getCreator().getId());
                    }
                    if(source.getPayProvider()!=null){
                        result.setPayProviderName(source.getPayProvider().getName());
                    }
                    if(source.getPayType()!=null){
                        result.setPayTypeName(String.valueOf(source.getPayType()));
                    }
        return result;
    }

}

