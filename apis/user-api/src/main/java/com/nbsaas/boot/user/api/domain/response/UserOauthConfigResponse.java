package com.nbsaas.boot.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserOauthConfigResponse  implements Serializable {
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