package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.SearchBean;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@SearchBean(items = {
        @SearchItem(label = "用户id", name = "user", key = "userInfo.id", classType = Long.class, operator = Operator.eq)
})
@Data
@Entity
@Table(name = "user_role")
@org.hibernate.annotations.Table(appliesTo = "user_role", comment = "用户角色表")
public class UserRole extends AbstractEntity {

    @FieldConvert
    @Comment("用户id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo userInfo;

    @Comment("角色id")
    private Long roleId;
}
