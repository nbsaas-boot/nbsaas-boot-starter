package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.PayUserApi;
import com.nbsaas.boot.pay.data.entity.PayUser;
import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayUserSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayUserSimple;
import com.nbsaas.boot.pay.rest.convert.PayUserSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.PayUserEntityConvert;
import com.nbsaas.boot.pay.rest.convert.PayUserResponseConvert;
import com.nbsaas.boot.pay.data.repository.PayUserRepository;

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
public class PayUserResource extends BaseResource<PayUser,PayUserResponse, PayUserSimple, PayUserDataRequest>  implements PayUserApi {

    @Resource
    private PayUserRepository payUserRepository;

    @Override
    public JpaRepositoryImplementation<PayUser, Serializable> getJpaRepository() {
        return payUserRepository;
    }

    @Override
    public Function<PayUser, PayUserSimple> getConvertSimple() {
        return new PayUserSimpleConvert();
    }

    @Override
    public Function<PayUserDataRequest, PayUser> getConvertForm() {
        return new PayUserEntityConvert();
    }

    @Override
    public Function<PayUser, PayUserResponse> getConvertResponse() {
    return new PayUserResponseConvert();
    }




}


