package com.nbsaas.boot.pay.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.pay.api.domain.enums.Method;
            import com.nbsaas.boot.pay.api.domain.enums.PayState;
/**
* 请求对象
*/
@Data
public class PaymentDataRequest implements Serializable,RequestId {

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

        /**
        * 
        **/
            //private String payConfigNameName;

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