package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.TenantAccount;
import com.nbsaas.boot.pay.api.domain.request.TenantAccountDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.trade.data.entity.TradeAccount;

/**
* 请求对象转换成实体对象
*/

public class TenantAccountEntityConvert  implements Converter<TenantAccount, TenantAccountDataRequest> {

    @Override
    public TenantAccount convert(TenantAccountDataRequest source) {
        TenantAccount result = new TenantAccount();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getAccount()!=null){
                    TradeAccount account =new TradeAccount();
                    account.setId(source.getAccount());
                    result.setAccount(account);
                    }
        return result;
    }
}

