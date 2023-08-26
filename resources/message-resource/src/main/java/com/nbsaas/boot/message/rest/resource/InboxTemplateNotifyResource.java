package com.nbsaas.boot.message.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.message.api.apis.InboxTemplateNotifyApi;
import com.nbsaas.boot.message.data.entity.InboxTemplateNotify;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateNotifyDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateNotifySearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateNotifyResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateNotifySimple;
import com.nbsaas.boot.message.rest.convert.InboxTemplateNotifySimpleConvert;
import com.nbsaas.boot.message.rest.convert.InboxTemplateNotifyEntityConvert;
import com.nbsaas.boot.message.rest.convert.InboxTemplateNotifyResponseConvert;
import com.nbsaas.boot.message.data.repository.InboxTemplateNotifyRepository;

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
public class InboxTemplateNotifyResource extends BaseResource<InboxTemplateNotify,InboxTemplateNotifyResponse, InboxTemplateNotifySimple, InboxTemplateNotifyDataRequest>  implements InboxTemplateNotifyApi {

    @Resource
    private InboxTemplateNotifyRepository inboxTemplateNotifyRepository;

    @Override
    public JpaRepositoryImplementation<InboxTemplateNotify, Serializable> getJpaRepository() {
        return inboxTemplateNotifyRepository;
    }

    @Override
    public Function<InboxTemplateNotify, InboxTemplateNotifySimple> getConvertSimple() {
        return new InboxTemplateNotifySimpleConvert();
    }

    @Override
    public Function<InboxTemplateNotifyDataRequest, InboxTemplateNotify> getConvertForm() {
        return new InboxTemplateNotifyEntityConvert();
    }

    @Override
    public Function<InboxTemplateNotify, InboxTemplateNotifyResponse> getConvertResponse() {
    return new InboxTemplateNotifyResponseConvert();
    }




}


