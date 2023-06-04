package com.nbsaas.boot.user.api.domain.simple;

import com.nbsaas.boot.user.api.domain.enums.AccountType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserAccountSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private String username;

    /**
     *
     **/
    private Long user;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     *
     **/
    private Integer loginSize;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private AccountType accountType;

    /**
     * 添加时间
     **/
    private Date addDate;


}