package com.nbsaas.boot.config.rest.convert;

import com.nbsaas.boot.config.api.domain.response.ConfigResponse;
import com.nbsaas.boot.config.data.entity.Config;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 实体对象转化成响应对象
 */

public class ConfigResponseConvert implements Converter
        <ConfigResponse, Config> {

    @Override
    public ConfigResponse convert(Config source) {
        ConfigResponse result = new ConfigResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

