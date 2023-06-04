package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.user.api.domain.enums.SecurityType;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户密码集合
 */


@Data
@Entity
@Table(name = "user_password")
public class UserPassword extends AbstractEntity {

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    /**
     * 校验次数
     */
    private Integer checkSize;

    /**
     * 密码
     */
    @Column(length = 50)
    private String password;

    /**
     * 盐
     */
    @Column(length = 50)
    private String salt;

    private SecurityType securityType;

}
