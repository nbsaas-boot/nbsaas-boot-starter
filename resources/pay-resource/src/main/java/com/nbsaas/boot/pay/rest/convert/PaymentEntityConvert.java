package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.Payment;
import com.nbsaas.boot.pay.api.domain.request.PaymentDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.pay.data.entity.PayConfig;
            import com.nbsaas.boot.pay.data.entity.PayUser;

/**
* 请求对象转换成实体对象
*/

public class PaymentEntityConvert  implements Converter<Payment, PaymentDataRequest> {

    @Override
    public Payment convert(PaymentDataRequest source) {
        Payment result = new Payment();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getPayConfig()!=null){
                    PayConfig payConfig =new PayConfig();
                    payConfig.setId(source.getPayConfig());
                    result.setPayConfig(payConfig);
                    }
                    if(source.getUser()!=null){
                    PayUser user =new PayUser();
                    user.setId(source.getUser());
                    result.setUser(user);
                    }
        return result;
    }
}

