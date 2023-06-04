package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户账号
 * <p>
 * Created by ada on 2016/12/20.
 */

@Data
@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractEntity {

    /**
     * 用户名
     */
    @Column(length = 50)
    private String username;
    /**
     * 账号类型
     */
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    /**
     * 登陆次数
     */
    private Integer loginSize;


    /**
     * 用户信息
     */
    @FieldConvert
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo user;


}
