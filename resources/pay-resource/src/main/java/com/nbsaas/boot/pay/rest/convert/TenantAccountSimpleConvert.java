package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.TenantAccount;
import com.nbsaas.boot.pay.api.domain.simple.TenantAccountSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class TenantAccountSimpleConvert implements Converter<TenantAccountSimple, TenantAccount> {




@Override
public TenantAccountSimple convert(TenantAccount source) {
    TenantAccountSimple result = new TenantAccountSimple();

                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setKey(source.getKey());
                if(source.getAccount()!=null){
                    result.setAccount(source.getAccount().getId());
                }
                result.setLastDate(source.getLastDate());


    return result;
}

}