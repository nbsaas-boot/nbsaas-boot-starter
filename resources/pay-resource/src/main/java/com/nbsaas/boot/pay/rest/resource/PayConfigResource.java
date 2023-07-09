package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.PayConfigApi;
import com.nbsaas.boot.pay.data.entity.PayConfig;
import com.nbsaas.boot.pay.api.domain.request.PayConfigDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayConfigSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayConfigResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayConfigSimple;
import com.nbsaas.boot.pay.rest.convert.PayConfigSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.PayConfigEntityConvert;
import com.nbsaas.boot.pay.rest.convert.PayConfigResponseConvert;
import com.nbsaas.boot.pay.data.repository.PayConfigRepository;

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
public class PayConfigResource extends BaseResource<PayConfig,PayConfigResponse, PayConfigSimple, PayConfigDataRequest>  implements PayConfigApi {

    @Resource
    private PayConfigRepository payConfigRepository;

    @Override
    public JpaRepositoryImplementation<PayConfig, Serializable> getJpaRepository() {
        return payConfigRepository;
    }

    @Override
    public Function<PayConfig, PayConfigSimple> getConvertSimple() {
        return new PayConfigSimpleConvert();
    }

    @Override
    public Function<PayConfigDataRequest, PayConfig> getConvertForm() {
        return new PayConfigEntityConvert();
    }

    @Override
    public Function<PayConfig, PayConfigResponse> getConvertResponse() {
    return new PayConfigResponseConvert();
    }




}


