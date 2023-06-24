package com.nbsaas.boot.config.data.entity;


import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@org.hibernate.annotations.Table(appliesTo = "nbsaas_common_config", comment = "基础配置功能")
@FormAnnotation(title = "基础配置功能", model = "基础配置")
@Data
@Entity
@Table(name = "nbsaas_common_config")
public class Config extends AbstractEntity {

    @Comment("配置类标识")
    @Column(unique = true)
    private String className;


    @Comment("配置json数据")
    private String configData;
}
