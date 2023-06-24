package com.nbsaas.boot.user.api.domain.response;

import com.nbsaas.boot.rest.enums.StoreState;
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
public class UserAccessLogResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Long consumeTime;

    /**
     *
     **/
    private Long creator;

    /**
     *
     **/
    private String ip;

    /**
     *
     **/
    private String creatorName;

    /**
     *
     **/
    //枚举
    private StoreState storeState;

    private String storeStateName;

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
    private String url;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

}