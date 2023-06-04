package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;

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
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     *
     **/
    private Integer state;

    /**
     *
     **/
    private String name;

    /**
     *
     **/
    private String className;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private String model;

    /**
     *
     **/
    private String appSecret;

    /**
     *
     **/
    private String appKey;

    /**
     * 添加时间
     **/
    private Date addDate;
}