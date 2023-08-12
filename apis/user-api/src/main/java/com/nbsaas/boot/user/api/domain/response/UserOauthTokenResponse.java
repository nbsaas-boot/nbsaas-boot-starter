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
        * 用户unionId
        **/
            private String unionId;

        /**
        * 用户openId
        **/
            private String openId;

        /**
        * 第三方登录配置
        **/
            private Long userOauthConfig;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 访问token
        **/
            private String accessToken;

        /**
        * token类型
        **/
            private String tokenType;

        /**
        * 绑定用户
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 过期时间
        **/
            private Long expiresTime;

        /**
        * 刷新token
        **/
            private String refreshToken;

        /**
        * 登录次数
        **/
            private Integer loginSize;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}