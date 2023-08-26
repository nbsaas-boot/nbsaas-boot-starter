package com.nbsaas.boot.message.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* description: message_inbox 收件箱 实体类
*/

@org.hibernate.annotations.Table(appliesTo = "bs_msg_inbox",comment = "消息收件箱")
@Data
@FormAnnotation(model = "消息收件箱", title = "消息收件箱" )
@Entity
@Table(name = "bs_msg_inbox")
public class Inbox extends AbstractEntity {


    /**
    * user_id 用户id
    */
    private Long userId;

    /**
    * inbox_template_id 收件箱定义id
    */
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private InboxTemplate inboxTemplate;

    /**
    * total_num 消息总数量
    */
    private Long totalNum;

    /**
    * un_read_num 未读数量
    */
    private Long unReadNum;

    /**
    * name 收件箱名称
    */
    private String name;

    /**
    * icon 收件箱icon
    */
    private String icon;

    /**
    * data_key 标识
    */
    private String dataKey;


}