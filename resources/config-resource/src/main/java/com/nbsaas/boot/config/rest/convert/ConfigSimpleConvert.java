package com.nbsaas.boot.config.rest.convert;

import com.nbsaas.boot.config.api.domain.simple.ConfigSimple;
import com.nbsaas.boot.config.data.entity.Config;
import com.nbsaas.boot.rest.api.Converter;

/**
 * 列表对象转换器
 */

public class ConfigSimpleConvert implements Converter<ConfigSimple, Config> {


    @Override
    public ConfigSimple convert(Config source) {
        ConfigSimple result = new ConfigSimple();

        result.setConfigData(source.getConfigData());
        result.setClassName(source.getClassName());
        result.setId(source.getId());
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());


        return result;
    }

}