package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.response.StructureResponse;
import com.nbsaas.boot.user.data.entity.Structure;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 实体对象转化成响应对象
 */

public class StructureResponseConvert implements Converter
        <StructureResponse, Structure> {

    @Override
    public StructureResponse convert(Structure source) {
        StructureResponse result = new StructureResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        return result;
    }

}

