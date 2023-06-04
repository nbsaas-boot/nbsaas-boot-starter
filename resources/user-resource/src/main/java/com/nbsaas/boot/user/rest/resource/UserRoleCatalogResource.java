package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserRoleCatalogApi;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserRoleCatalogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserRoleCatalogSimple;
import com.nbsaas.boot.user.data.entity.UserRoleCatalog;
import com.nbsaas.boot.user.data.repository.UserRoleCatalogRepository;
import com.nbsaas.boot.user.rest.convert.UserRoleCatalogEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserRoleCatalogResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserRoleCatalogSimpleConvert;
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
public class UserRoleCatalogResource extends BaseResource<UserRoleCatalog, UserRoleCatalogResponse, UserRoleCatalogSimple, UserRoleCatalogDataRequest> implements UserRoleCatalogApi {

    @Resource
    private UserRoleCatalogRepository userRoleCatalogRepository;

    @Override
    public JpaRepositoryImplementation<UserRoleCatalog, Serializable> getJpaRepository() {
        return userRoleCatalogRepository;
    }

    @Override
    public Function<UserRoleCatalog, UserRoleCatalogSimple> getConvertSimple() {
        return new UserRoleCatalogSimpleConvert();
    }

    @Override
    public Function
            <UserRoleCatalogDataRequest, UserRoleCatalog> getConvertForm() {
        return new UserRoleCatalogEntityConvert();
    }

    @Override
    public Function<UserRoleCatalog, UserRoleCatalogResponse> getConvertResponse() {
        return new UserRoleCatalogResponseConvert();
    }

}


