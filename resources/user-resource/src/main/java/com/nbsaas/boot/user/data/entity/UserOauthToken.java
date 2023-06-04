package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.*;

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
    private String access_token;
    /**
     * 刷新token
     */
    private String refresh_token;

    /**
     * token类型
     */
    private String token_type;

    /**
     * 用户id
     */
    private String uid;


    /**
     * 过期时间
     */
    private Long expires_in;

    /**
     * 和用户绑定
     */
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;

    private Integer loginSize;


}
