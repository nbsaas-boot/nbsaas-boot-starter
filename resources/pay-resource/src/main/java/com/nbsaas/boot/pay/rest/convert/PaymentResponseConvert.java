package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.Payment;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class PaymentResponseConvert  implements Converter
<PaymentResponse,Payment> {

@Override
public PaymentResponse convert(Payment source) {
PaymentResponse  result = new  PaymentResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getMethod()!=null){
                result.setMethodName(String.valueOf(source.getMethod()));
            }
            if(source.getPayState()!=null){
                result.setPayStateName(String.valueOf(source.getPayState()));
            }
            if(source.getPayConfig()!=null){
                result.setPayConfigName(source.getPayConfig().getName());
            }
            if(source.getPayConfig()!=null){
                result.setPayConfig(source.getPayConfig().getId());
            }
            if(source.getUser()!=null){
                result.setUser(source.getUser().getId());
            }
return result;
}

}

