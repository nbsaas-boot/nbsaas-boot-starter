package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayConfig;
import com.nbsaas.boot.pay.api.domain.request.PayConfigDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.pay.data.entity.PayProvider;
            import com.nbsaas.boot.pay.data.entity.PayUser;

/**
* 请求对象转换成实体对象
*/

public class PayConfigEntityConvert  implements Converter<PayConfig, PayConfigDataRequest> {

    @Override
    public PayConfig convert(PayConfigDataRequest source) {
        PayConfig result = new PayConfig();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getPayProvider()!=null){
                    PayProvider payProvider =new PayProvider();
                    payProvider.setId(source.getPayProvider());
                    result.setPayProvider(payProvider);
                    }
                    if(source.getCreator()!=null){
                    PayUser creator =new PayUser();
                    creator.setId(source.getCreator());
                    result.setCreator(creator);
                    }
        return result;
    }
}

