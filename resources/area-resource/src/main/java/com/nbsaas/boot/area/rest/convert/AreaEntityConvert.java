package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.api.domain.request.AreaDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class AreaEntityConvert  implements Converter<Area, AreaDataRequest> {
@Override
public Area convert(AreaDataRequest source) {
Area result = new Area();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

