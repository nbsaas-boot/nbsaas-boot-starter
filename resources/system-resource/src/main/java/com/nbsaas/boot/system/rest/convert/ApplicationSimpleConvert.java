package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Application;
import com.nbsaas.boot.system.api.domain.simple.ApplicationSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ApplicationSimpleConvert implements Converter<ApplicationSimple, Application> {




@Override
public ApplicationSimple convert(Application source) {
    ApplicationSimple result = new ApplicationSimple();

                result.setName(source.getName());
                result.setAppKey(source.getAppKey());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}