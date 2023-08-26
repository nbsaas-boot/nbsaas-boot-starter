package com.nbsaas.boot.message.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.message.api.apis.InboxMessageApi;
import com.nbsaas.boot.message.data.entity.InboxMessage;
import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxMessageSearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxMessageResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxMessageSimple;
import com.nbsaas.boot.message.rest.convert.InboxMessageSimpleConvert;
import com.nbsaas.boot.message.rest.convert.InboxMessageEntityConvert;
import com.nbsaas.boot.message.rest.convert.InboxMessageResponseConvert;
import com.nbsaas.boot.message.data.repository.InboxMessageRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class InboxMessageResource extends BaseResource<InboxMessage,InboxMessageResponse, InboxMessageSimple, InboxMessageDataRequest>  implements InboxMessageApi {

    @Resource
    private InboxMessageRepository inboxMessageRepository;

    @Override
    public JpaRepositoryImplementation<InboxMessage, Serializable> getJpaRepository() {
        return inboxMessageRepository;
    }

    @Override
    public Function<InboxMessage, InboxMessageSimple> getConvertSimple() {
        return new InboxMessageSimpleConvert();
    }

    @Override
    public Function<InboxMessageDataRequest, InboxMessage> getConvertForm() {
        return new InboxMessageEntityConvert();
    }

    @Override
    public Function<InboxMessage, InboxMessageResponse> getConvertResponse() {
    return new InboxMessageResponseConvert();
    }




}


