package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.StructureDataRequest;
import com.nbsaas.boot.user.data.entity.Structure;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class StructureEntityConvert implements Converter<Structure, StructureDataRequest> {

    @Override
    public Structure convert(StructureDataRequest source) {
        Structure result = new Structure();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            Structure parent = new Structure();
            parent.setId(source.getParent());
            result.setParent(parent);
        }
        return result;
    }
}

