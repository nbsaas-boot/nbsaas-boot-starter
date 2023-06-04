package com.nbsaas.boot.user.api.domain.response;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.nbsaas.boot.user.api.domain.enums.LoginState;
import com.nbsaas.boot.rest.enums.StoreState;

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

    private Long user;

    private LoginState state;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private Long id;

    private StoreState storeState;

    private String client;

    private String note;

    private String account;

    private String ip;

    private String userName;

    private String password;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;


}