package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayProvider;
import com.nbsaas.boot.pay.api.domain.request.PayProviderDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.pay.data.entity.PayUser;

/**
* 请求对象转换成实体对象
*/

public class PayProviderEntityConvert  implements Converter<PayProvider, PayProviderDataRequest> {

    @Override
    public PayProvider convert(PayProviderDataRequest source) {
        PayProvider result = new PayProvider();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getCreator()!=null){
                    PayUser creator =new PayUser();
                    creator.setId(source.getCreator());
                    result.setCreator(creator);
                    }
        return result;
    }
}

