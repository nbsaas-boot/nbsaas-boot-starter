package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.BasicTradeAccountApi;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.BasicTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.BasicTradeAccountSimple;
import com.nbsaas.boot.trade.data.entity.BasicTradeAccount;
import com.nbsaas.boot.trade.data.repository.BasicTradeAccountRepository;
import com.nbsaas.boot.trade.rest.convert.BasicTradeAccountEntityConvert;
import com.nbsaas.boot.trade.rest.convert.BasicTradeAccountResponseConvert;
import com.nbsaas.boot.trade.rest.convert.BasicTradeAccountSimpleConvert;
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
public class BasicTradeAccountResource extends BaseResource<BasicTradeAccount, BasicTradeAccountResponse, BasicTradeAccountSimple, BasicTradeAccountDataRequest> implements BasicTradeAccountApi {

    @Resource
    private BasicTradeAccountRepository basicTradeAccountRepository;

    @Override
    public JpaRepositoryImplementation<BasicTradeAccount, Serializable> getJpaRepository() {
        return basicTradeAccountRepository;
    }

    @Override
    public Function<BasicTradeAccount, BasicTradeAccountSimple> getConvertSimple() {
        return new BasicTradeAccountSimpleConvert();
    }

    @Override
    public Function
            <BasicTradeAccountDataRequest, BasicTradeAccount> getConvertForm() {
        return new BasicTradeAccountEntityConvert();
    }

    @Override
    public Function<BasicTradeAccount, BasicTradeAccountResponse> getConvertResponse() {
        return new BasicTradeAccountResponseConvert();
    }

}


