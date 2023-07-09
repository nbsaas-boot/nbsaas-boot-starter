package com.nbsaas.boot.pay.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.pay.api.domain.enums.SendState;

/**
* 列表对象
*/
@Data
public class CashPaymentSimple implements Serializable {

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