package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.TradeAccountExceptionApi;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountExceptionResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountExceptionSimple;
import com.nbsaas.boot.trade.data.entity.TradeAccountException;
import com.nbsaas.boot.trade.data.repository.TradeAccountExceptionRepository;
import com.nbsaas.boot.trade.rest.convert.TradeAccountExceptionEntityConvert;
import com.nbsaas.boot.trade.rest.convert.TradeAccountExceptionResponseConvert;
import com.nbsaas.boot.trade.rest.convert.TradeAccountExceptionSimpleConvert;
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
public class TradeAccountExceptionResource extends BaseResource<TradeAccountException, TradeAccountExceptionResponse, TradeAccountExceptionSimple, TradeAccountExceptionDataRequest> implements TradeAccountExceptionApi {

    @Resource
    private TradeAccountExceptionRepository tradeAccountExceptionRepository;

    @Override
    public JpaRepositoryImplementation<TradeAccountException, Serializable> getJpaRepository() {
        return tradeAccountExceptionRepository;
    }

    @Override
    public Function<TradeAccountException, TradeAccountExceptionSimple> getConvertSimple() {
        return new TradeAccountExceptionSimpleConvert();
    }

    @Override
    public Function
            <TradeAccountExceptionDataRequest, TradeAccountException> getConvertForm() {
        return new TradeAccountExceptionEntityConvert();
    }

    @Override
    public Function<TradeAccountException, TradeAccountExceptionResponse> getConvertResponse() {
        return new TradeAccountExceptionResponseConvert();
    }

}


