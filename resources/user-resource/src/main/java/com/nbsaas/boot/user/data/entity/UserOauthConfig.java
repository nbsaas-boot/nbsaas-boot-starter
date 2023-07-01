package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ada on 2017/7/20.
 */

@org.hibernate.annotations.Table(appliesTo = "user_oauth_config", comment = "第三方登录配置表")
@Data
@Entity
@Table(name = "user_oauth_config")
public class UserOauthConfig extends AbstractEntity {

    /**
     * 第三方登陆名称
     */
    @Comment("第三方登陆名称")
    private String name;

    @Comment("第三方登陆标识")
    private String model;


    @Comment("程序key")
    private String appKey;


    @Comment("程序密钥")
    private String appSecret;

    @Comment("启用状态  1启用 2未启用")
    private Integer state;


    @Comment("java实现类")
    private String className;

}
