package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.SearchItem;
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
    @SearchItem(label = "登陆名称",name = "name")
    @FormField(title = "第三方登陆名称",grid = true,width = "160",required = true,col = 22)
    @Comment("第三方登陆名称")
    private String name;

    @SearchItem(label = "登陆标识",name = "model")
    @FormField(title = "第三方登陆标识",grid = true,width = "160",required = true,col = 22)
    @Comment("第三方登陆标识")
    private String model;

    @FormField(title = "程序key",grid = true,width = "200",required = true,col = 22)
    @Comment("程序key")
    private String appKey;

    @FormField(title = "程序密钥",grid = true,width = "20000",required = true,col = 22)
    @Comment("程序密钥")
    private String appSecret;

    @Comment("启用状态  1启用 2未启用")
    private Integer state;

    @FormField(title = "java实现类",required = true,col = 22)
    @Comment("java实现类")
    private String className;

}
