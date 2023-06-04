package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.response.SequenceResponse;
import com.nbsaas.boot.system.data.entity.Sequence;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 实体对象转化成响应对象
 */

public class SequenceResponseConvert implements Converter
        <SequenceResponse, Sequence> {

    @Override
    public SequenceResponse convert(Sequence source) {
        SequenceResponse result = new SequenceResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

