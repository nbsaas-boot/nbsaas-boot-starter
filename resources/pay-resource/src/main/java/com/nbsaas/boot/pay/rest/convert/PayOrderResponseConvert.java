package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayOrder;
import com.nbsaas.boot.pay.api.domain.response.PayOrderResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class PayOrderResponseConvert  implements Converter<PayOrderResponse,PayOrder> {

    @Override
    public PayOrderResponse convert(PayOrder source) {
        PayOrderResponse  result = new  PayOrderResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getOrderStatus()!=null){
                        result.setOrderStatusName(String.valueOf(source.getOrderStatus()));
                    }
                    if(source.getShippingStatus()!=null){
                        result.setShippingStatusName(String.valueOf(source.getShippingStatus()));
                    }
                    if(source.getPaymentStatus()!=null){
                        result.setPaymentStatusName(String.valueOf(source.getPaymentStatus()));
                    }
        return result;
    }

}

