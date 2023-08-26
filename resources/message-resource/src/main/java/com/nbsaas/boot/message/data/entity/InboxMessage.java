package com.nbsaas.boot.message.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.jpa.data.entity.User;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * description: message_inbox_message 消息 实体类
 */

@SearchBean(items = {
        @SearchItem(label = "key", name = "inboxKey", key = "inbox.dataKey", show = false, operator = Operator.eq),
        @SearchItem(label = "收件人", name = "toUser", key = "toUser.id", classType = Long.class, show = false, operator = Operator.eq),
        @SearchItem(label = "发件人", name = "sendUser", key = "sendUser.id", classType = Long.class, show = false, operator = Operator.eq),
        @SearchItem(label = "状态", name = "state", key = "state", classType = Integer.class, show = false, operator = Operator.eq)

})
@org.hibernate.annotations.Table(appliesTo = "bs_msg_inbox_message", comment = "消息")
@Data
@FormAnnotation(model = "消息", title = "消息")
@Entity
@Table(name = "bs_msg_inbox_message")
public class InboxMessage extends AbstractEntity {


    /**
     * inbox_id 收件箱id
     */
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Inbox inbox;


    /**
     * title 消息标题
     */
    private String title;

    /**
     * note 消息内容
     */
    private String note;

    /**
     * send_user 发送人id
     */
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private User sendUser;


    /**
     * to_user 收件人id
     */
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private User toUser;


    /**
     * state 阅读状态 1未读 2已读
     */
    private Integer state;

    /**
     * ext_data 扩展json数据
     */
    private String extData;


}