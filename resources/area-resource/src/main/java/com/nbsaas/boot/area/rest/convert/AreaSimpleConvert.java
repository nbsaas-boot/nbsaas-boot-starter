package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.api.domain.simple.AreaSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AreaSimpleConvert implements Converter
<AreaSimple, Area> {




@Override
public AreaSimple convert(Area source) {
AreaSimple result = new AreaSimple();

            result.setLastDate(source.getLastDate());
            result.setSortNum(source.getSortNum());
            result.setId(source.getId());
            result.setCode(source.getCode());
            result.setLft(source.getLft());
            result.setRgt(source.getRgt());
            result.setDepth(source.getDepth());
            result.setName(source.getName());
            result.setLng(source.getLng());
            result.setLat(source.getLat());
            result.setIds(source.getIds());
            result.setAddDate(source.getAddDate());


return result;
}

}