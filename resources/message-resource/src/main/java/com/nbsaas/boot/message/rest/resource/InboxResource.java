package com.nbsaas.boot.message.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.message.api.apis.InboxApi;
import com.nbsaas.boot.message.data.entity.Inbox;
import com.nbsaas.boot.message.api.domain.request.InboxDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxSearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxSimple;
import com.nbsaas.boot.message.rest.convert.InboxSimpleConvert;
import com.nbsaas.boot.message.rest.convert.InboxEntityConvert;
import com.nbsaas.boot.message.rest.convert.InboxResponseConvert;
import com.nbsaas.boot.message.data.repository.InboxRepository;

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
public class InboxResource extends BaseResource<Inbox,InboxResponse, InboxSimple, InboxDataRequest>  implements InboxApi {

    @Resource
    private InboxRepository inboxRepository;

    @Override
    public JpaRepositoryImplementation<Inbox, Serializable> getJpaRepository() {
        return inboxRepository;
    }

    @Override
    public Function<Inbox, InboxSimple> getConvertSimple() {
        return new InboxSimpleConvert();
    }

    @Override
    public Function<InboxDataRequest, Inbox> getConvertForm() {
        return new InboxEntityConvert();
    }

    @Override
    public Function<Inbox, InboxResponse> getConvertResponse() {
    return new InboxResponseConvert();
    }




}


