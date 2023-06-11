package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户oauth登陆信息
 *
 * @author 73552
 */

@Data
@Entity
@Table(name = "user_oauth_token")
public class UserOauthToken extends AbstractEntity {

    /**
     * 访问token
     */
    private String accessToken;
    /**
     * 刷新token
     */
    private String refreshToken;

    /**
     * token类型
     */
    private String tokenType;

    /**
     * 用户id
     */
    private String openId;


    private String unionId;


    /**
     * 过期时间
     */
    private Long expiresTime;

    /**
     * 和用户绑定
     */
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    private Integer loginSize;

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserOauthConfig userOauthConfig;

}
