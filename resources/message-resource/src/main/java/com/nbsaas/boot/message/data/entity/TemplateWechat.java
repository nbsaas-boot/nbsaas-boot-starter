package com.nbsaas.boot.message.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: message_template_wechat 微信消息模板表 实体类
 */


@org.hibernate.annotations.Table(appliesTo = "bs_msg_inbox_template_wechat", comment = "微信消息通知")
@Data
@FormAnnotation(model = "微信消息通知", title = "微信消息通知")
@Entity
@Table(name = "bs_msg_inbox_template_wechat")
public class TemplateWechat extends AbstractEntity {


    /**
     * code 模板编号，唯一确定模板
     */
    private String code;

    /**
     * name 模板名称
     */
    private String name;

    /**
     * content 模板内容
     */
    private String content;


}