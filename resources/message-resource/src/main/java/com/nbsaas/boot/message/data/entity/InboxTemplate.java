package com.nbsaas.boot.message.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
* description: message_inbox_template 收件箱定义模板 实体类
*/

@org.hibernate.annotations.Table(appliesTo = "bs_msg_inbox_template",comment = "收件箱模板")
@Data
@FormAnnotation(model = "收件箱模板", title = "收件箱模板")
@Entity
@Table(name = "bs_msg_inbox_template")
public class InboxTemplate extends AbstractEntity {



    @Comment("收件箱名称")
    private String name;

    @Comment("收件箱icon")
    private String icon;

    @Comment("标识")
    private String dataKey;


}