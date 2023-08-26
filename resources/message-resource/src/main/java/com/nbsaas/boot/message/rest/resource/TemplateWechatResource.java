package com.nbsaas.boot.message.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.message.api.apis.TemplateWechatApi;
import com.nbsaas.boot.message.data.entity.TemplateWechat;
import com.nbsaas.boot.message.api.domain.request.TemplateWechatDataRequest;
import com.nbsaas.boot.message.api.domain.request.TemplateWechatSearchRequest;
import com.nbsaas.boot.message.api.domain.response.TemplateWechatResponse;
import com.nbsaas.boot.message.api.domain.simple.TemplateWechatSimple;
import com.nbsaas.boot.message.rest.convert.TemplateWechatSimpleConvert;
import com.nbsaas.boot.message.rest.convert.TemplateWechatEntityConvert;
import com.nbsaas.boot.message.rest.convert.TemplateWechatResponseConvert;
import com.nbsaas.boot.message.data.repository.TemplateWechatRepository;

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
public class TemplateWechatResource extends BaseResource<TemplateWechat,TemplateWechatResponse, TemplateWechatSimple, TemplateWechatDataRequest>  implements TemplateWechatApi {

    @Resource
    private TemplateWechatRepository templateWechatRepository;

    @Override
    public JpaRepositoryImplementation<TemplateWechat, Serializable> getJpaRepository() {
        return templateWechatRepository;
    }

    @Override
    public Function<TemplateWechat, TemplateWechatSimple> getConvertSimple() {
        return new TemplateWechatSimpleConvert();
    }

    @Override
    public Function<TemplateWechatDataRequest, TemplateWechat> getConvertForm() {
        return new TemplateWechatEntityConvert();
    }

    @Override
    public Function<TemplateWechat, TemplateWechatResponse> getConvertResponse() {
    return new TemplateWechatResponseConvert();
    }




}


