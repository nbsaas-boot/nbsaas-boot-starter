package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Dict;
import com.nbsaas.boot.system.api.domain.request.DictDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class DictEntityConvert  implements Converter<Dict, DictDataRequest> {
@Override
public Dict convert(DictDataRequest source) {
Dict result = new Dict();
BeanDataUtils.copyProperties(source, result);
return result;
}
}

