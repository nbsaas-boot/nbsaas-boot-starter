package com.nbsaas.boot.user.api.domain.response;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.user.api.domain.enums.LoginState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserLoginLogResponse implements Serializable {
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
    //枚举
    private StoreState storeState;

    private String storeStateName;

    /**
     *
     **/
    //枚举
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