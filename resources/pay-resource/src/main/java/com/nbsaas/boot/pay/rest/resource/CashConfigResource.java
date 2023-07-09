package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.CashConfigApi;
import com.nbsaas.boot.pay.data.entity.CashConfig;
import com.nbsaas.boot.pay.api.domain.request.CashConfigDataRequest;
import com.nbsaas.boot.pay.api.domain.request.CashConfigSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;
import com.nbsaas.boot.pay.api.domain.simple.CashConfigSimple;
import com.nbsaas.boot.pay.rest.convert.CashConfigSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.CashConfigEntityConvert;
import com.nbsaas.boot.pay.rest.convert.CashConfigResponseConvert;
import com.nbsaas.boot.pay.data.repository.CashConfigRepository;

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
public class CashConfigResource extends BaseResource<CashConfig,CashConfigResponse, CashConfigSimple, CashConfigDataRequest>  implements CashConfigApi {

    @Resource
    private CashConfigRepository cashConfigRepository;

    @Override
    public JpaRepositoryImplementation<CashConfig, Serializable> getJpaRepository() {
        return cashConfigRepository;
    }

    @Override
    public Function<CashConfig, CashConfigSimple> getConvertSimple() {
        return new CashConfigSimpleConvert();
    }

    @Override
    public Function<CashConfigDataRequest, CashConfig> getConvertForm() {
        return new CashConfigEntityConvert();
    }

    @Override
    public Function<CashConfig, CashConfigResponse> getConvertResponse() {
    return new CashConfigResponseConvert();
    }




}


