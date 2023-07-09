package com.nbsaas.boot.pay.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.pay.api.domain.enums.SendState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class CashPaymentResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private Long tradeAccount;

        /**
        * 
        **/
            private String openId;

        /**
        * 
        **/
            private BigDecimal fee;

        /**
        * 
        **/
            //枚举
            private SendState sendState;

            private String sendStateName;

        /**
        * 
        **/
            private String cashNo;

        /**
        * 
        **/
            private String idNo;

        /**
        * 
        **/
            private String demo;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private BigDecimal money;

        /**
        * 
        **/
            private String phone;

        /**
        * 
        **/
            private String bussNo;

        /**
        * 
        **/
            private String appId;

        /**
        * 
        **/
            private String name;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long cashConfig;

        /**
        * 
        **/
            private BigDecimal cash;

        /**
        * 
        **/
            private Long user;

        /**
        * 
        **/
            private String cashConfigName;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}