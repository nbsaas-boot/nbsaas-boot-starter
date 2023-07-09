package com.nbsaas.boot.pay.rest.convert;

import com.nbsaas.boot.pay.data.entity.PayOrder;
import com.nbsaas.boot.pay.api.domain.simple.PayOrderSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class PayOrderSimpleConvert implements Converter<PayOrderSimple, PayOrder> {




@Override
public PayOrderSimple convert(PayOrder source) {
    PayOrderSimple result = new PayOrderSimple();

                result.setOffsetAmount(source.getOffsetAmount());
                result.setFee(source.getFee());
                result.setFreight(source.getFreight());
                if(source.getOrderStatus()!=null){
                    result.setOrderStatusName(String.valueOf(source.getOrderStatus()));
                }
                result.setOrderStatus(source.getOrderStatus());
                result.setTax(source.getTax());
                result.setAddDate(source.getAddDate());
                result.setPoint(source.getPoint());
                if(source.getShippingStatus()!=null){
                    result.setShippingStatusName(String.valueOf(source.getShippingStatus()));
                }
                result.setShippingStatus(source.getShippingStatus());
                result.setCouponDiscount(source.getCouponDiscount());
                result.setPromotionDiscount(source.getPromotionDiscount());
                result.setAmountPaid(source.getAmountPaid());
                result.setMoney(source.getMoney());
                result.setSn(source.getSn());
                result.setId(source.getId());
                if(source.getPaymentStatus()!=null){
                    result.setPaymentStatusName(String.valueOf(source.getPaymentStatus()));
                }
                result.setPaymentStatus(source.getPaymentStatus());
                result.setLastDate(source.getLastDate());


    return result;
}

}