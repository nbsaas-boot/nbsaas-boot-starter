package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserPasswordApi;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.boot.user.data.entity.UserPassword;
import com.nbsaas.boot.user.data.repository.UserPasswordRepository;
import com.nbsaas.boot.user.rest.convert.UserPasswordEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserPasswordResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserPasswordSimpleConvert;
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
public class UserPasswordResource extends BaseResource<UserPassword, UserPasswordResponse, UserPasswordSimple, UserPasswordDataRequest> implements UserPasswordApi {

    @Resource
    private UserPasswordRepository userPasswordRepository;

    @Override
    public JpaRepositoryImplementation<UserPassword, Serializable> getJpaRepository() {
        return userPasswordRepository;
    }

    @Override
    public Function<UserPassword, UserPasswordSimple> getConvertSimple() {
        return new UserPasswordSimpleConvert();
    }

    @Override
    public Function
            <UserPasswordDataRequest, UserPassword> getConvertForm() {
        return new UserPasswordEntityConvert();
    }

    @Override
    public Function<UserPassword, UserPasswordResponse> getConvertResponse() {
        return new UserPasswordResponseConvert();
    }

}


