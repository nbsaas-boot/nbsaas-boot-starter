package com.nbsaas.boot.user.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserOauthConfigSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private String name;

    /**
     *
     **/
    private String model;

    /**
     *
     **/
    private String appKey;

    /**
     *
     **/
    private String appSecret;

    /**
     *
     **/
    private String className;

    /**
     *
     **/
    private Integer state;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     * 最新修改时间
     **/
    private Date lastDate;


}