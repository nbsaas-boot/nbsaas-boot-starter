package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class UserOauthConfigDataRequest implements Serializable, RequestId {

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