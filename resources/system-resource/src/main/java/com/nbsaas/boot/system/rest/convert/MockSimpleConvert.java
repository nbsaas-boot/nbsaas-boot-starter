package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Mock;
import com.nbsaas.boot.system.api.domain.simple.MockSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class MockSimpleConvert implements Converter<MockSimple, Mock> {




@Override
public MockSimple convert(Mock source) {
    MockSimple result = new MockSimple();

                result.setName(source.getName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setContent(source.getContent());
                result.setLastDate(source.getLastDate());


    return result;
}

}