package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.CashPayment;
import com.nbsaas.boot.pay.api.domain.response.CashPaymentResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class CashPaymentResponseConvert  implements Converter
<CashPaymentResponse,CashPayment> {

@Override
public CashPaymentResponse convert(CashPayment source) {
CashPaymentResponse  result = new  CashPaymentResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getTradeAccount()!=null){
                result.setTradeAccount(source.getTradeAccount().getId());
            }
            if(source.getSendState()!=null){
                result.setSendStateName(String.valueOf(source.getSendState()));
            }
            if(source.getCashConfig()!=null){
                result.setCashConfig(source.getCashConfig().getId());
            }
            if(source.getUser()!=null){
                result.setUser(source.getUser().getId());
            }
            if(source.getCashConfig()!=null){
                result.setCashConfigName(source.getCashConfig().getName());
            }
return result;
}

}

