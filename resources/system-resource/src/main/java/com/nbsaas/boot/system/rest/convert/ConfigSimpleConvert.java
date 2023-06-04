package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Config;
import com.nbsaas.boot.system.api.domain.simple.ConfigSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ConfigSimpleConvert implements Converter
<ConfigSimple, Config> {




@Override
public ConfigSimple convert(Config source) {
ConfigSimple result = new ConfigSimple();

            result.setLastDate(source.getLastDate());
            result.setId(source.getId());
            result.setContent(source.getContent());
            result.setAddDate(source.getAddDate());


return result;
}

}