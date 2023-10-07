package com.nbsaas.boot.pay.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.pay.api.domain.enums.OrderStatus;
            import com.nbsaas.boot.pay.api.domain.enums.ShippingStatus;
            import com.nbsaas.boot.pay.api.domain.enums.PaymentStatus;
/**
* 请求对象
*/
@Data
public class PayOrderDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 调整金额
        **/
            private BigDecimal offsetAmount;

        /**
        * 支付手续费
        **/
            private BigDecimal fee;

        /**
        * 运费
        **/
            private BigDecimal freight;

        /**
        * 
        **/
            private OrderStatus orderStatus;

        /**
        * 税金
        **/
            private BigDecimal tax;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 赠送积分
        **/
            private Long point;

        /**
        * 
        **/
            private ShippingStatus shippingStatus;

        /**
        * 优惠券折扣
        **/
            private BigDecimal couponDiscount;

        /**
        * 促销折扣
        **/
            private BigDecimal promotionDiscount;

        /**
        * 已付金额
        **/
            private BigDecimal amountPaid;

        /**
        * 订单价格
        **/
            private BigDecimal money;

        /**
        * 订单编号
        **/
            private String sn;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private PaymentStatus paymentStatus;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}