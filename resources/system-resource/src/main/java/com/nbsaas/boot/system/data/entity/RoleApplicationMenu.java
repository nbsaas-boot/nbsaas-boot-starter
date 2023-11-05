package com.nbsaas.boot.system.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@org.hibernate.annotations.Table(appliesTo = "sys_role_app_menu", comment = "角色应用菜单")
@Data
@Entity
@Table(name = "sys_role_app_menu")
public class RoleApplicationMenu extends AbstractEntity {


    @JoinColumn(name = "role_id")
    @FieldConvert
    @Comment("角色id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @JoinColumn(name = "menu_id")
    @FieldConvert
    @Comment("菜单id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationMenu menu;
}
