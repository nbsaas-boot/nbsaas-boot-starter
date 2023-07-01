package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

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
@org.hibernate.annotations.Table(appliesTo = "user_oauth_token", comment = "用户oauth登陆信息")
public class UserOauthToken extends AbstractEntity {

    /**
     * 访问token
     */
    @Comment("访问token")
    private String accessToken;
    /**
     * 刷新token
     */

    @Comment("刷新token")
    private String refreshToken;

    /**
     * token类型
     */
    @Comment("token类型")
    private String tokenType;

    /**
     * 用户id
     */
    @Comment("用户openId")
    private String openId;

    @Comment("用户unionId")
    private String unionId;


    @Comment("过期时间")
    private Long expiresTime;

    @Comment("绑定用户")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;


    @Comment("登录次数")
    private Integer loginSize;


    @Comment("第三方登录配置")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserOauthConfig userOauthConfig;

}
