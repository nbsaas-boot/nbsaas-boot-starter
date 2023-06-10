package com.nbsaas.boot.config.rest.resource;

import com.nbsaas.boot.config.api.apis.ConfigApi;
import com.nbsaas.boot.config.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.config.api.domain.response.ConfigResponse;
import com.nbsaas.boot.config.api.domain.simple.ConfigSimple;
import com.nbsaas.boot.config.data.entity.Config;
import com.nbsaas.boot.config.data.repository.ConfigRepository;
import com.nbsaas.boot.config.rest.convert.ConfigEntityConvert;
import com.nbsaas.boot.config.rest.convert.ConfigResponseConvert;
import com.nbsaas.boot.config.rest.convert.ConfigSimpleConvert;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.utils.BeanDataUtils;
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
public class ConfigResource extends BaseResource<Config, ConfigResponse, ConfigSimple, ConfigDataRequest>
        implements ConfigApi,
        Function<ConfigDataRequest, Config> {

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
    public Function<ConfigDataRequest, Config> getConvertForm() {
        return this;
    }

    @Override
    public Function<Config, ConfigResponse> getConvertResponse() {
        return new ConfigResponseConvert();
    }


    @Override
    public Config apply(ConfigDataRequest source) {
        Config result = new Config();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


