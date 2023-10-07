package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.CashConfig;
import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class CashConfigResponseConvert  implements Converter<CashConfigResponse,CashConfig> {

    @Override
    public CashConfigResponse convert(CashConfig source) {
        CashConfigResponse  result = new  CashConfigResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getFeeType()!=null){
                        result.setFeeTypeName(String.valueOf(source.getFeeType()));
                    }
        return result;
    }

}

