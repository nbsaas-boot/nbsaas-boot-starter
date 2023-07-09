package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.CashPayment;
import com.nbsaas.boot.pay.api.domain.simple.CashPaymentSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class CashPaymentSimpleConvert implements Converter<CashPaymentSimple, CashPayment> {




@Override
public CashPaymentSimple convert(CashPayment source) {
    CashPaymentSimple result = new CashPaymentSimple();

                result.setNote(source.getNote());
                if(source.getTradeAccount()!=null){
                    result.setTradeAccount(source.getTradeAccount().getId());
                }
                result.setOpenId(source.getOpenId());
                result.setFee(source.getFee());
                if(source.getSendState()!=null){
                    result.setSendStateName(String.valueOf(source.getSendState()));
                }
                result.setSendState(source.getSendState());
                result.setCashNo(source.getCashNo());
                result.setIdNo(source.getIdNo());
                result.setDemo(source.getDemo());
                result.setAddDate(source.getAddDate());
                result.setMoney(source.getMoney());
                result.setPhone(source.getPhone());
                result.setBussNo(source.getBussNo());
                result.setAppId(source.getAppId());
                result.setName(source.getName());
                result.setId(source.getId());
                if(source.getCashConfig()!=null){
                    result.setCashConfig(source.getCashConfig().getId());
                }
                result.setCash(source.getCash());
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }
                if(source.getCashConfig()!=null){
                    result.setCashConfigName(source.getCashConfig().getName());
                }
                result.setLastDate(source.getLastDate());


    return result;
}

}