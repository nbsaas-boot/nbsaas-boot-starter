package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.Payment;
import com.nbsaas.boot.pay.api.domain.simple.PaymentSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class PaymentSimpleConvert implements Converter<PaymentSimple, Payment> {




@Override
public PaymentSimple convert(Payment source) {
    PaymentSimple result = new PaymentSimple();

                result.setAmount(source.getAmount());
                if(source.getMethod()!=null){
                    result.setMethodName(String.valueOf(source.getMethod()));
                }
                result.setMethod(source.getMethod());
                result.setFee(source.getFee());
                result.setHandle(source.getHandle());
                if(source.getPayState()!=null){
                    result.setPayStateName(String.valueOf(source.getPayState()));
                }
                result.setPayState(source.getPayState());
                if(source.getPayConfig()!=null){
                    result.setPayConfigName(source.getPayConfig().getName());
                }
                result.setAddDate(source.getAddDate());
                result.setBussId(source.getBussId());
                result.setPayNo(source.getPayNo());
                result.setBank(source.getBank());
                if(source.getPayConfig()!=null){
                    result.setPayConfig(source.getPayConfig().getId());
                }
                result.setBussNo(source.getBussNo());
                result.setExpire(source.getExpire());
                result.setPaymentMethod(source.getPaymentMethod());
                result.setSn(source.getSn());
                result.setId(source.getId());
                result.setPaymentDate(source.getPaymentDate());
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }
                result.setAccount(source.getAccount());
                result.setLastDate(source.getLastDate());


    return result;
}

}