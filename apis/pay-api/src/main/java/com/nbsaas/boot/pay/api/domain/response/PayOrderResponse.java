package com.nbsaas.boot.pay.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.pay.api.domain.enums.OrderStatus;
            import com.nbsaas.boot.pay.api.domain.enums.ShippingStatus;
            import com.nbsaas.boot.pay.api.domain.enums.PaymentStatus;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class PayOrderResponse  implements Serializable {
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
            //枚举
            private OrderStatus orderStatus;

            private String orderStatusName;

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
            //枚举
            private ShippingStatus shippingStatus;

            private String shippingStatusName;

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
            //枚举
            private PaymentStatus paymentStatus;

            private String paymentStatusName;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}