package com.nbsaas.boot.config.rest.convert;

import com.nbsaas.boot.config.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.config.data.entity.Config;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class ConfigEntityConvert implements Converter<Config, ConfigDataRequest> {
    @Override
    public Config convert(ConfigDataRequest source) {
        Config result = new Config();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

