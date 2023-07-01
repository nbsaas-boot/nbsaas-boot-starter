package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.user.api.domain.enums.SecurityType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * 用户密码集合
 */


@Data
@Entity
@Table(name = "user_password")
@org.hibernate.annotations.Table(appliesTo = "user_password", comment = "用户密码")
public class UserPassword extends AbstractEntity {

    @Comment("用户")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    @Comment("校验次数")
    private Integer checkSize;

    @Comment("密码")
    @Column(length = 50)
    private String password;


    @Comment("加密盐")
    @Column(length = 50)
    private String salt;


    @Comment("安全类型")
    private SecurityType securityType;

}
