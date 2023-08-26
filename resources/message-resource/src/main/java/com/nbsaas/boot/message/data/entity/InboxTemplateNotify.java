package com.nbsaas.boot.message.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* description: message_inbox_template_notify  实体类
*/


@org.hibernate.annotations.Table(appliesTo = "bs_msg_inbox_template_notify",comment = "消息通知")
@Data
@FormAnnotation(model = "消息通知", title = "消息通知")
@Entity
@Table(name = "bs_msg_inbox_template_notify")
public class InboxTemplateNotify extends AbstractEntity {


    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private InboxTemplate inboxTemplate;

    /**
    * name 通知名称
    */
    private String name;

    /**
    * class_name 实现类
    */
    private String className;

    /**
    * state 状态  1未启用 2启用
    */
    private Integer state;

}