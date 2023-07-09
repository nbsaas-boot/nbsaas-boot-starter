package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayOrder;
import com.nbsaas.boot.pay.api.domain.request.PayOrderDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class PayOrderEntityConvert  implements Converter<PayOrder, PayOrderDataRequest> {

    @Override
    public PayOrder convert(PayOrderDataRequest source) {
        PayOrder result = new PayOrder();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

