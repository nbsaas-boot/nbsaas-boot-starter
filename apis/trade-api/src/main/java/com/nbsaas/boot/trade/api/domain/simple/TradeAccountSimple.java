package com.nbsaas.boot.trade.api.domain.simple;

import com.nbsaas.boot.trade.api.domain.enums.AccountType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class TradeAccountSimple implements Serializable {

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