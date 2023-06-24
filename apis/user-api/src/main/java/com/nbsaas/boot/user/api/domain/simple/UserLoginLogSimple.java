package com.nbsaas.boot.user.api.domain.simple;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.user.api.domain.enums.LoginState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserLoginLogSimple implements Serializable {

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
    private String password;

    /**
     *
     **/
    private String ip;

    /**
     *
     **/
    private String client;

    /**
     *
     **/
    private StoreState storeState;

    private String storeStateName;

    /**
     *
     **/
    private LoginState state;

    private String stateName;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private String userName;

    /**
     *
     **/
    private Long user;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     *
     **/
    private String account;

    /**
     * 最新修改时间
     **/
    private Date lastDate;


}