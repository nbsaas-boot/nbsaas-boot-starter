package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.api.domain.request.AreaHotDataRequest;
import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.data.entity.AreaHot;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class AreaHotEntityConvert implements Converter<AreaHot, AreaHotDataRequest> {

    @Override
    public AreaHot convert(AreaHotDataRequest source) {
        AreaHot result = new AreaHot();
        BeanDataUtils.copyProperties(source, result);
        if (source.getArea() != null) {
            Area area = new Area();
            area.setId(source.getArea());
            result.setArea(area);
        }
        return result;
    }
}

