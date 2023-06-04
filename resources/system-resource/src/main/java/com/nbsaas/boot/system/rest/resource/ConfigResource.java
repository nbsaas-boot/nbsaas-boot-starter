package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.ConfigApi;
import com.nbsaas.boot.system.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.system.api.domain.response.ConfigResponse;
import com.nbsaas.boot.system.api.domain.simple.ConfigSimple;
import com.nbsaas.boot.system.data.entity.Config;
import com.nbsaas.boot.system.data.repository.ConfigRepository;
import com.nbsaas.boot.system.rest.convert.ConfigEntityConvert;
import com.nbsaas.boot.system.rest.convert.ConfigResponseConvert;
import com.nbsaas.boot.system.rest.convert.ConfigSimpleConvert;
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
public class ConfigResource extends BaseResource<Config, ConfigResponse, ConfigSimple, ConfigDataRequest> implements ConfigApi {

    @Resource
    private ConfigRepository configRepository;

    @Override
    public JpaRepositoryImplementation<Config, Serializable> getJpaRepository() {
        return configRepository;
    }

    @Override
    public Function<Config, ConfigSimple> getConvertSimple() {
        return new ConfigSimpleConvert();
    }

    @Override
    public Function
            <ConfigDataRequest, Config> getConvertForm() {
        return new ConfigEntityConvert();
    }

    @Override
    public Function<Config, ConfigResponse> getConvertResponse() {
        return new ConfigResponseConvert();
    }

}


