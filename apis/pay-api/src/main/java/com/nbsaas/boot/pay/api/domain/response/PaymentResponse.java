package com.nbsaas.boot.pay.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.pay.api.domain.enums.Method;
            import com.nbsaas.boot.pay.api.domain.enums.PayState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class PaymentResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private BigDecimal amount;

        /**
        * 
        **/
            //枚举
            private Method method;

            private String methodName;

        /**
        * 
        **/
            private BigDecimal fee;

        /**
        * 
        **/
            private String handle;

        /**
        * 
        **/
            //枚举
            private PayState payState;

            private String payStateName;

        /**
        * 
        **/
            private String payConfigName;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Long bussId;

        /**
        * 
        **/
            private String payNo;

        /**
        * 
        **/
            private String bank;

        /**
        * 
        **/
            private Long payConfig;

        /**
        * 
        **/
            private String bussNo;

        /**
        * 
        **/
            private Date expire;

        /**
        * 
        **/
            private String paymentMethod;

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
            private Date paymentDate;

        /**
        * 
        **/
            private Long user;

        /**
        * 
        **/
            private String account;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}