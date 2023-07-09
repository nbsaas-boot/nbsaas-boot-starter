package com.nbsaas.boot.pay.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.pay.api.domain.enums.Method;
            import com.nbsaas.boot.pay.api.domain.enums.PayState;

/**
* 列表对象
*/
@Data
public class PaymentSimple implements Serializable {

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