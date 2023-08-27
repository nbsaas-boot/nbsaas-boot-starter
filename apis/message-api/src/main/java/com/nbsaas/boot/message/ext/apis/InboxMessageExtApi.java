package com.nbsaas.boot.message.ext.apis;

import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;
import com.nbsaas.boot.message.api.domain.response.InboxMessageResponse;
import com.nbsaas.boot.message.ext.domain.request.InboxMessageSendRequest;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface InboxMessageExtApi {


    /**
     * 发送消息
     *
     * @param request 消息发送对象
     * @return 消息集合
     */
    ResponseObject<InboxMessageResponse> sendMessage(InboxMessageSendRequest request);


    /**
     * 阅读某个消息
     *
     * @param request 消息信息
     * @return 阅读状态
     */
    ResponseObject<?> read(InboxMessageDataRequest request);


}
