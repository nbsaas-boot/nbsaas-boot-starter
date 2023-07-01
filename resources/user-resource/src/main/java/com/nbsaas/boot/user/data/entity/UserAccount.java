package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
 * 用户账号
 * <p>
 * Created by ada on 2016/12/20.
 */
@org.hibernate.annotations.Table(appliesTo = "user_account",comment = "用户账号")
@Data
@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractEntity {

    @Comment("用户名")
    @Column(length = 50)
    private String username;


    @Comment("账号类型")
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    @Comment("登陆次数")
    private Integer loginSize;


    @Comment("用户id")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;


}
