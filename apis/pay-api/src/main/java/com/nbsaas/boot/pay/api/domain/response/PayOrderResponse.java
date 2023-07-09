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
        * 
        **/
            private BigDecimal offsetAmount;

        /**
        * 
        **/
            private BigDecimal fee;

        /**
        * 
        **/
            private BigDecimal freight;

        /**
        * 
        **/
            //枚举
            private OrderStatus orderStatus;

            private String orderStatusName;

        /**
        * 
        **/
            private BigDecimal tax;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Long point;

        /**
        * 
        **/
            //枚举
            private ShippingStatus shippingStatus;

            private String shippingStatusName;

        /**
        * 
        **/
            private BigDecimal couponDiscount;

        /**
        * 
        **/
            private BigDecimal promotionDiscount;

        /**
        * 
        **/
            private BigDecimal amountPaid;

        /**
        * 
        **/
            private BigDecimal money;

        /**
        * 
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