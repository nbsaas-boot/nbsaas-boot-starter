package com.nbsaas.boot.trade.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.trade.api.domain.enums.AccountType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class TradeAccountResponse  implements Serializable {
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
            private String salt;

        /**
        * 
        **/
            //枚举
            private AccountType accountType;

            private String accountTypeName;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private String checkValue;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Integer serialNo;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}