package com.nbsaas.boot.system.data.entity;

import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.InputType;
import com.nbsaas.boot.code.annotation.NoSimple;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: sys_application  实体类
 */
@Data
@Entity
@Table(name = "sys_app")
public class Application extends LongEntity {


    /**
     * name 应用名称
     */
    @SearchItem(label = "应用名称", name = "name")
    @FormField(title = "应用名称", grid = true, required = true, col = 22, width = "200")
    @Comment("应用名称")
    private String name;

    /**
     * app_key 应用key
     */
    @FormField(title = "应用key", grid = true, col = 22, width = "200")
    @Comment("应用key")
    private String appKey;

    /**
     * note 应用介绍
     */
    @NoSimple
    @FormField(title = "应用介绍", type = InputType.textarea, col = 22)
    @Comment("应用介绍")
    private String note;

    @FormField(title = "添加时间", grid = true, width = "10000", ignore = true)
    @Comment("添加时间")
    private Date addDate;

    /**
     * 最新修改时间
     */
    @Comment("最新修改时间")
    private Date lastDate;

}