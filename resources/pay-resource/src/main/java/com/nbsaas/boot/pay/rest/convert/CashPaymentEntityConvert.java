package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.CashPayment;
import com.nbsaas.boot.pay.api.domain.request.CashPaymentDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.trade.data.entity.TradeAccount;
            import com.nbsaas.boot.pay.data.entity.CashConfig;
            import com.nbsaas.boot.pay.data.entity.PayUser;

/**
* 请求对象转换成实体对象
*/

public class CashPaymentEntityConvert  implements Converter<CashPayment, CashPaymentDataRequest> {

    @Override
    public CashPayment convert(CashPaymentDataRequest source) {
        CashPayment result = new CashPayment();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getTradeAccount()!=null){
                    TradeAccount tradeAccount =new TradeAccount();
                    tradeAccount.setId(source.getTradeAccount());
                    result.setTradeAccount(tradeAccount);
                    }
                    if(source.getCashConfig()!=null){
                    CashConfig cashConfig =new CashConfig();
                    cashConfig.setId(source.getCashConfig());
                    result.setCashConfig(cashConfig);
                    }
                    if(source.getUser()!=null){
                    PayUser user =new PayUser();
                    user.setId(source.getUser());
                    result.setUser(user);
                    }
        return result;
    }
}

