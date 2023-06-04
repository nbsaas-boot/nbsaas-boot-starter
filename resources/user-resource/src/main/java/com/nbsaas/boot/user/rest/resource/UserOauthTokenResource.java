package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserOauthTokenApi;
import com.nbsaas.boot.user.data.entity.UserOauthToken;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserOauthTokenResponse;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;
import com.nbsaas.boot.user.rest.convert.UserOauthTokenSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthTokenEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthTokenResponseConvert;
import com.nbsaas.boot.user.data.repository.UserOauthTokenRepository;

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
 * 业务接口实现
 */
@Transactional
@Service
public class UserOauthTokenResource extends BaseResource<UserOauthToken, UserOauthTokenResponse, UserOauthTokenSimple, UserOauthTokenDataRequest> implements UserOauthTokenApi {

    @Resource
    private UserOauthTokenRepository userOauthTokenRepository;

    @Override
    public JpaRepositoryImplementation<UserOauthToken, Serializable> getJpaRepository() {
        return userOauthTokenRepository;
    }

    @Override
    public Function<UserOauthToken, UserOauthTokenSimple> getConvertSimple() {
        return new UserOauthTokenSimpleConvert();
    }

    @Override
    public Function
            <UserOauthTokenDataRequest, UserOauthToken> getConvertForm() {
        return new UserOauthTokenEntityConvert();
    }

    @Override
    public Function<UserOauthToken, UserOauthTokenResponse> getConvertResponse() {
        return new UserOauthTokenResponseConvert();
    }

}


