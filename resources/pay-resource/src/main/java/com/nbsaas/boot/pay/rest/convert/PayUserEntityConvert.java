package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayUser;
import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.trade.data.entity.TradeAccount;

/**
* 请求对象转换成实体对象
*/

public class PayUserEntityConvert  implements Converter<PayUser, PayUserDataRequest> {

    @Override
    public PayUser convert(PayUserDataRequest source) {
        PayUser result = new PayUser();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getTradeAccount()!=null){
                    TradeAccount tradeAccount =new TradeAccount();
                    tradeAccount.setId(source.getTradeAccount());
                    result.setTradeAccount(tradeAccount);
                    }
        return result;
    }
}

