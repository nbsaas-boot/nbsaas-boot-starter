package com.nbsaas.boot.user.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserOauthTokenSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Long expires_in;

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
    private String token_type;

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
    private String uid;

    /**
     *
     **/
    private String refresh_token;

    /**
     *
     **/
    private String access_token;

    /**
     * 添加时间
     **/
    private Date addDate;


}