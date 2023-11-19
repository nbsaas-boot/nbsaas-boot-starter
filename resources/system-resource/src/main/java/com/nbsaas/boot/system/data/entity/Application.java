package com.nbsaas.boot.system.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.LongEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: sys_application  实体类
 */

@ComposeView
@FormAnnotation(title = "应用")
@Data
@Entity
@Table(name = "sys_app",indexes = {@Index(columnList = "name",name = "sys_app_name_index")})
public class Application extends LongEntity {

    @SearchItem(label = "应用标识", name = "appKey")
    @FormField(title = "应用标识", grid = true, col = 22, width = "200",required = true)
    @Comment("应用标识")
    @Column(unique = true,length = 60)
    private String appKey;


    /**
     * name 应用名称
     */
    @SearchItem(label = "应用名称", name = "name")
    @FormField(title = "应用名称", grid = true, required = true, col = 22, width = "200")
    @Comment("应用名称")
    private String name;



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