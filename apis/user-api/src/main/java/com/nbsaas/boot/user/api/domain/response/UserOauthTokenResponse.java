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
public class UserOauthTokenResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String access_token;

        /**
        * 
        **/
            private String refresh_token;

        /**
        * 
        **/
            private String uid;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String token_type;

        /**
        * 
        **/
            private Long expires_in;

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
            private Integer loginSize;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}