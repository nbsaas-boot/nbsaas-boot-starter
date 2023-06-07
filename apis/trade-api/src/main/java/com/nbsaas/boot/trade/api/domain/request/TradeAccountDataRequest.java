package com.nbsaas.boot.trade.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.trade.api.domain.enums.AccountType;
/**
* 请求对象
*/
@Data
public class TradeAccountDataRequest implements Serializable,RequestId {

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
            private AccountType accountType;

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