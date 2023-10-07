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
        * 付款金额
        **/
            private BigDecimal amount;

        /**
        * 
        **/
            //枚举
            private Method method;

            private String methodName;

        /**
        * 支付手续费
        **/
            private BigDecimal fee;

        /**
        * 业务处理器
        **/
            private String handle;

        /**
        * 
        **/
            //枚举
            private PayState payState;

            private String payStateName;

        /**
        * 配置id
        **/
            private String payConfigName;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 业务id
        **/
            private Long bussId;

        /**
        * 支付单号
        **/
            private String payNo;

        /**
        * 收款银行
        **/
            private String bank;

        /**
        * 配置id
        **/
            private Long payConfig;

        /**
        * 业务单号
        **/
            private String bussNo;

        /**
        * 到期时间
        **/
            private Date expire;

        /**
        * 支付方式
        **/
            private String paymentMethod;

        /**
        * 编号
        **/
            private String sn;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 付款日期
        **/
            private Date paymentDate;

        /**
        * 
        **/
            private Long user;

        /**
        * 收款账号
        **/
            private String account;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}