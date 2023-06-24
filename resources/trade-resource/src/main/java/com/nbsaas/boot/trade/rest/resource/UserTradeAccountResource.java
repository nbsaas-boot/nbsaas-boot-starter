package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.UserTradeAccountApi;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.UserTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.UserTradeAccountSimple;
import com.nbsaas.boot.trade.data.entity.UserTradeAccount;
import com.nbsaas.boot.trade.data.repository.UserTradeAccountRepository;
import com.nbsaas.boot.trade.rest.convert.UserTradeAccountEntityConvert;
import com.nbsaas.boot.trade.rest.convert.UserTradeAccountResponseConvert;
import com.nbsaas.boot.trade.rest.convert.UserTradeAccountSimpleConvert;
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
public class UserTradeAccountResource extends BaseResource<UserTradeAccount, UserTradeAccountResponse, UserTradeAccountSimple, UserTradeAccountDataRequest> implements UserTradeAccountApi {

    @Resource
    private UserTradeAccountRepository userTradeAccountRepository;

    @Override
    public JpaRepositoryImplementation<UserTradeAccount, Serializable> getJpaRepository() {
        return userTradeAccountRepository;
    }

    @Override
    public Function<UserTradeAccount, UserTradeAccountSimple> getConvertSimple() {
        return new UserTradeAccountSimpleConvert();
    }

    @Override
    public Function
            <UserTradeAccountDataRequest, UserTradeAccount> getConvertForm() {
        return new UserTradeAccountEntityConvert();
    }

    @Override
    public Function<UserTradeAccount, UserTradeAccountResponse> getConvertResponse() {
        return new UserTradeAccountResponseConvert();
    }

}


