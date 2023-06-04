package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserLoginLogApi;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserLoginLogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.boot.user.data.entity.UserLoginLog;
import com.nbsaas.boot.user.data.repository.UserLoginLogRepository;
import com.nbsaas.boot.user.rest.convert.UserLoginLogEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserLoginLogResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserLoginLogSimpleConvert;
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
public class UserLoginLogResource extends BaseResource<UserLoginLog, UserLoginLogResponse, UserLoginLogSimple, UserLoginLogDataRequest> implements UserLoginLogApi {

    @Resource
    private UserLoginLogRepository userLoginLogRepository;

    @Override
    public JpaRepositoryImplementation<UserLoginLog, Serializable> getJpaRepository() {
        return userLoginLogRepository;
    }

    @Override
    public Function<UserLoginLog, UserLoginLogSimple> getConvertSimple() {
        return new UserLoginLogSimpleConvert();
    }

    @Override
    public Function
            <UserLoginLogDataRequest, UserLoginLog> getConvertForm() {
        return new UserLoginLogEntityConvert();
    }

    @Override
    public Function<UserLoginLog, UserLoginLogResponse> getConvertResponse() {
        return new UserLoginLogResponseConvert();
    }

}


