package com.nbsaas.boot.message.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.message.api.apis.InboxTemplateApi;
import com.nbsaas.boot.message.data.entity.InboxTemplate;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateSearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateSimple;
import com.nbsaas.boot.message.rest.convert.InboxTemplateSimpleConvert;
import com.nbsaas.boot.message.rest.convert.InboxTemplateEntityConvert;
import com.nbsaas.boot.message.rest.convert.InboxTemplateResponseConvert;
import com.nbsaas.boot.message.data.repository.InboxTemplateRepository;

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
public class InboxTemplateResource extends BaseResource<InboxTemplate,InboxTemplateResponse, InboxTemplateSimple, InboxTemplateDataRequest>  implements InboxTemplateApi {

    @Resource
    private InboxTemplateRepository inboxTemplateRepository;

    @Override
    public JpaRepositoryImplementation<InboxTemplate, Serializable> getJpaRepository() {
        return inboxTemplateRepository;
    }

    @Override
    public Function<InboxTemplate, InboxTemplateSimple> getConvertSimple() {
        return new InboxTemplateSimpleConvert();
    }

    @Override
    public Function<InboxTemplateDataRequest, InboxTemplate> getConvertForm() {
        return new InboxTemplateEntityConvert();
    }

    @Override
    public Function<InboxTemplate, InboxTemplateResponse> getConvertResponse() {
    return new InboxTemplateResponseConvert();
    }




}


