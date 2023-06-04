package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.code.annotation.CatalogClass;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@CatalogClass
@Data
@FormAnnotation(title = "角色分类配置", model = "角色分类", menu = "1,2,8")
@Entity
@Table(name = "user_role_catalog")
public class UserRoleCatalog extends CatalogEntity {


    /**
     * 父id
     */
    @FieldName
    @SearchItem(label = "分类", name = "parent", key = "parent.id", classType = "Integer", operator = "eq")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserRoleCatalog parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<UserRoleCatalog> children;

}
