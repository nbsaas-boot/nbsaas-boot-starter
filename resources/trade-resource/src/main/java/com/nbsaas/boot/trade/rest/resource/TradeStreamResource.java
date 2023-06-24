package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.TradeStreamApi;
import com.nbsaas.boot.trade.api.domain.request.TradeStreamDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeStreamResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeStreamSimple;
import com.nbsaas.boot.trade.data.entity.TradeStream;
import com.nbsaas.boot.trade.data.repository.TradeStreamRepository;
import com.nbsaas.boot.trade.rest.convert.TradeStreamEntityConvert;
import com.nbsaas.boot.trade.rest.convert.TradeStreamResponseConvert;
import com.nbsaas.boot.trade.rest.convert.TradeStreamSimpleConvert;
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
public class TradeStreamResource extends BaseResource<TradeStream, TradeStreamResponse, TradeStreamSimple, TradeStreamDataRequest> implements TradeStreamApi {

    @Resource
    private TradeStreamRepository tradeStreamRepository;

    @Override
    public JpaRepositoryImplementation<TradeStream, Serializable> getJpaRepository() {
        return tradeStreamRepository;
    }

    @Override
    public Function<TradeStream, TradeStreamSimple> getConvertSimple() {
        return new TradeStreamSimpleConvert();
    }

    @Override
    public Function
            <TradeStreamDataRequest, TradeStream> getConvertForm() {
        return new TradeStreamEntityConvert();
    }

    @Override
    public Function<TradeStream, TradeStreamResponse> getConvertResponse() {
        return new TradeStreamResponseConvert();
    }

}


