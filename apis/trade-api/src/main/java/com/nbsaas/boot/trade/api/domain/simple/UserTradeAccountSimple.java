package com.nbsaas.boot.trade.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserTradeAccountSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


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
    private String key;

    /**
     * 最新修改时间
     **/
    private Date lastDate;


}