package com.nbsaas.boot.trade.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class TradeAccountExceptionSimple implements Serializable {

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