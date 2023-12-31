package com.nbsaas.boot.system.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@CatalogClass
@CreateByUser
@ComposeView
@FormAnnotation(title = "菜单管理", model = "菜单", menu = "1,54,56")
@Data
@Entity
@Table(name = "sys_app_menu")
public class ApplicationMenu extends CatalogEntity {

    @Comment("分类")
    private Integer catalog;

    @OrderBy("sortNum asc")
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<ApplicationMenu> children;

    @Comment("图标")
    private String icon;

    private Long num;

    @FieldConvert
    @FieldName
    @Comment("父菜单id")
    @JoinColumn(name = "parent_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationMenu parent;

    @Comment("路径")
    private String path;

    @Comment("路由")
    private String router;

    @Comment("权限")
    private String permission;

    @Comment("创建人id")
    private Long creator;


    @JoinColumn(name = "app_id")
    @Comment("应用")
    @SearchItem(label = "应用", name = "app", key = "app.id", operator = Operator.eq)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Application app;

    @Comment("菜单类型")
    private Integer menuType;

    @Override
    public Serializable getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
