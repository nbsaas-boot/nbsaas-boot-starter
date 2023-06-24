package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.TradeAccountApi;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountSimple;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import com.nbsaas.boot.trade.data.repository.TradeAccountRepository;
import com.nbsaas.boot.trade.rest.convert.TradeAccountEntityConvert;
import com.nbsaas.boot.trade.rest.convert.TradeAccountResponseConvert;
import com.nbsaas.boot.trade.rest.convert.TradeAccountSimpleConvert;
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
public class TradeAccountResource extends BaseResource<TradeAccount, TradeAccountResponse, TradeAccountSimple, TradeAccountDataRequest> implements TradeAccountApi {

    @Resource
    private TradeAccountRepository tradeAccountRepository;

    @Override
    public JpaRepositoryImplementation<TradeAccount, Serializable> getJpaRepository() {
        return tradeAccountRepository;
    }

    @Override
    public Function<TradeAccount, TradeAccountSimple> getConvertSimple() {
        return new TradeAccountSimpleConvert();
    }

    @Override
    public Function
            <TradeAccountDataRequest, TradeAccount> getConvertForm() {
        return new TradeAccountEntityConvert();
    }

    @Override
    public Function<TradeAccount, TradeAccountResponse> getConvertResponse() {
        return new TradeAccountResponseConvert();
    }

}


