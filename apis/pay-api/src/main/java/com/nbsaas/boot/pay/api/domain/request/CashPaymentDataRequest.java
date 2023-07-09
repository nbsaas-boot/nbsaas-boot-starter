package com.nbsaas.boot.pay.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.pay.api.domain.enums.SendState;
/**
* 请求对象
*/
@Data
public class CashPaymentDataRequest implements Serializable,RequestId {

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
            //private String cashConfigNameName;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}