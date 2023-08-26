package com.nbsaas.boot.message.ext.domain.request;

import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;
import lombok.Data;

/**
 * @description: message_inbox_message 消息
 */
@Data
public class InboxMessageSendRequest extends InboxMessageDataRequest {

    /**
     * 收件箱标识
     */
    private String key;

}