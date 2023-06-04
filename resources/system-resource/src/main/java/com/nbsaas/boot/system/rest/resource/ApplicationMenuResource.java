package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.ApplicationMenuApi;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationMenuResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.boot.system.data.entity.ApplicationMenu;
import com.nbsaas.boot.system.data.repository.ApplicationMenuRepository;
import com.nbsaas.boot.system.rest.convert.ApplicationMenuEntityConvert;
import com.nbsaas.boot.system.rest.convert.ApplicationMenuResponseConvert;
import com.nbsaas.boot.system.rest.convert.ApplicationMenuSimpleConvert;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class ApplicationMenuResource extends BaseResource<ApplicationMenu, ApplicationMenuResponse, ApplicationMenuSimple, ApplicationMenuDataRequest> implements ApplicationMenuApi {

    @Resource
    private ApplicationMenuRepository applicationMenuRepository;

    @Override
    public JpaRepositoryImplementation<ApplicationMenu, Serializable> getJpaRepository() {
        return applicationMenuRepository;
    }

    @Override
    public Function<ApplicationMenu, ApplicationMenuSimple> getConvertSimple() {
        return new ApplicationMenuSimpleConvert();
    }

    @Override
    public Function
            <ApplicationMenuDataRequest, ApplicationMenu> getConvertForm() {
        return new ApplicationMenuEntityConvert();
    }

    @Override
    public Function<ApplicationMenu, ApplicationMenuResponse> getConvertResponse() {
        return new ApplicationMenuResponseConvert();
    }

}


