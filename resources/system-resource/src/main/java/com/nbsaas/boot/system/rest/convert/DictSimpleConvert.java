package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Dict;
import com.nbsaas.boot.system.api.domain.simple.DictSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class DictSimpleConvert implements Converter
<DictSimple, Dict> {




@Override
public DictSimple convert(Dict source) {
DictSimple result = new DictSimple();

            result.setTitle(source.getTitle());
            result.setLastDate(source.getLastDate());
            result.setId(source.getId());
            result.setDictKey(source.getDictKey());
            result.setAddDate(source.getAddDate());


return result;
}

}