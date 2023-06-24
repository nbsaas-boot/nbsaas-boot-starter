package com.nbsaas.boot.trade.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class TradeAccountExceptionDataRequest implements Serializable, RequestId {

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
    //private String accountNameName;

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