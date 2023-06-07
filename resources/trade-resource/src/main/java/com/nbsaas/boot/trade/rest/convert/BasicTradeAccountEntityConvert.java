package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.trade.data.entity.BasicTradeAccount;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.trade.data.entity.TradeAccount;

/**
* 请求对象转换成实体对象
*/

public class BasicTradeAccountEntityConvert  implements Converter<BasicTradeAccount, BasicTradeAccountDataRequest> {
@Override
public BasicTradeAccount convert(BasicTradeAccountDataRequest source) {
BasicTradeAccount result = new BasicTradeAccount();
BeanDataUtils.copyProperties(source, result);
            if(source.getAccount()!=null){
            TradeAccount account =new TradeAccount();
            account.setId(source.getAccount());
            result.setAccount(account);
            }
return result;
}
}

