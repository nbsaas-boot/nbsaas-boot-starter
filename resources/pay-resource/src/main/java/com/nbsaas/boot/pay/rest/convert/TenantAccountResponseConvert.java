package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.TenantAccount;
import com.nbsaas.boot.pay.api.domain.response.TenantAccountResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class TenantAccountResponseConvert  implements Converter
<TenantAccountResponse,TenantAccount> {

@Override
public TenantAccountResponse convert(TenantAccount source) {
TenantAccountResponse  result = new  TenantAccountResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getAccount()!=null){
                result.setAccount(source.getAccount().getId());
            }
return result;
}

}

