package com.nbsaas.boot.trade.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class TradeAccountExceptionResponse  implements Serializable {
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
            private String accountName;

        /**
        * 
        **/
            private BigDecimal oldAmount;

        /**
        * 
        **/
            private String checkValue;

        /**
        * 
        **/
            private String oldSalt;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String oldCheckValue;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Long account;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}