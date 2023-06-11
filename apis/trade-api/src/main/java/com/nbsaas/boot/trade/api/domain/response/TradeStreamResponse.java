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
public class TradeStreamResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private BigDecimal preAmount;

        /**
        * 
        **/
            private String note;

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
            private Integer changeType;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private BigDecimal afterAmount;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private Long account;

        /**
        * 
        **/
            private Long info;

        /**
        * 
        **/
            private Integer serialNo;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}