package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayUser;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class PayUserResponseConvert  implements Converter
<PayUserResponse,PayUser> {

@Override
public PayUserResponse convert(PayUser source) {
PayUserResponse  result = new  PayUserResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getTradeAccount()!=null){
                result.setTradeAccount(source.getTradeAccount().getId());
            }
            if(source.getTradeAccount()!=null){
                result.setTradeAccountAmount(source.getTradeAccount().getAmount());
            }
return result;
}

}

