package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Mock;
import com.nbsaas.boot.system.api.domain.response.MockResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class MockResponseConvert  implements Converter<MockResponse,Mock> {

    @Override
    public MockResponse convert(Mock source) {
        MockResponse  result = new  MockResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

