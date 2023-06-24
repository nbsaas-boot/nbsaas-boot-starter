package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.TradeInfoApi;
import com.nbsaas.boot.trade.api.domain.request.TradeInfoDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeInfoSimple;
import com.nbsaas.boot.trade.data.entity.TradeInfo;
import com.nbsaas.boot.trade.data.repository.TradeInfoRepository;
import com.nbsaas.boot.trade.rest.convert.TradeInfoEntityConvert;
import com.nbsaas.boot.trade.rest.convert.TradeInfoResponseConvert;
import com.nbsaas.boot.trade.rest.convert.TradeInfoSimpleConvert;
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
public class TradeInfoResource extends BaseResource<TradeInfo, TradeInfoResponse, TradeInfoSimple, TradeInfoDataRequest> implements TradeInfoApi {

    @Resource
    private TradeInfoRepository tradeInfoRepository;

    @Override
    public JpaRepositoryImplementation<TradeInfo, Serializable> getJpaRepository() {
        return tradeInfoRepository;
    }

    @Override
    public Function<TradeInfo, TradeInfoSimple> getConvertSimple() {
        return new TradeInfoSimpleConvert();
    }

    @Override
    public Function
            <TradeInfoDataRequest, TradeInfo> getConvertForm() {
        return new TradeInfoEntityConvert();
    }

    @Override
    public Function<TradeInfo, TradeInfoResponse> getConvertResponse() {
        return new TradeInfoResponseConvert();
    }

}


