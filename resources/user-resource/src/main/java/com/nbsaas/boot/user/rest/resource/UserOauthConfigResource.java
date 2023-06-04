package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserOauthConfigApi;
import com.nbsaas.boot.user.api.domain.request.UserOauthConfigDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserOauthConfigResponse;
import com.nbsaas.boot.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.boot.user.data.entity.UserOauthConfig;
import com.nbsaas.boot.user.data.repository.UserOauthConfigRepository;
import com.nbsaas.boot.user.rest.convert.UserOauthConfigEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthConfigResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthConfigSimpleConvert;
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
public class UserOauthConfigResource extends BaseResource<UserOauthConfig, UserOauthConfigResponse, UserOauthConfigSimple, UserOauthConfigDataRequest> implements UserOauthConfigApi {

    @Resource
    private UserOauthConfigRepository userOauthConfigRepository;

    @Override
    public JpaRepositoryImplementation<UserOauthConfig, Serializable> getJpaRepository() {
        return userOauthConfigRepository;
    }

    @Override
    public Function<UserOauthConfig, UserOauthConfigSimple> getConvertSimple() {
        return new UserOauthConfigSimpleConvert();
    }

    @Override
    public Function
            <UserOauthConfigDataRequest, UserOauthConfig> getConvertForm() {
        return new UserOauthConfigEntityConvert();
    }

    @Override
    public Function<UserOauthConfig, UserOauthConfigResponse> getConvertResponse() {
        return new UserOauthConfigResponseConvert();
    }

}


