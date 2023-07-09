package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.PayProviderApi;
import com.nbsaas.boot.pay.data.entity.PayProvider;
import com.nbsaas.boot.pay.api.domain.request.PayProviderDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayProviderSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayProviderResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayProviderSimple;
import com.nbsaas.boot.pay.rest.convert.PayProviderSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.PayProviderEntityConvert;
import com.nbsaas.boot.pay.rest.convert.PayProviderResponseConvert;
import com.nbsaas.boot.pay.data.repository.PayProviderRepository;

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
public class PayProviderResource extends BaseResource<PayProvider,PayProviderResponse, PayProviderSimple, PayProviderDataRequest>  implements PayProviderApi {

    @Resource
    private PayProviderRepository payProviderRepository;

    @Override
    public JpaRepositoryImplementation<PayProvider, Serializable> getJpaRepository() {
        return payProviderRepository;
    }

    @Override
    public Function<PayProvider, PayProviderSimple> getConvertSimple() {
        return new PayProviderSimpleConvert();
    }

    @Override
    public Function<PayProviderDataRequest, PayProvider> getConvertForm() {
        return new PayProviderEntityConvert();
    }

    @Override
    public Function<PayProvider, PayProviderResponse> getConvertResponse() {
    return new PayProviderResponseConvert();
    }




}


