package com.nbsaas.boot.area.rest.convert;

import com.nbsaas.boot.area.data.entity.AreaHot;
import com.nbsaas.boot.area.api.domain.simple.AreaHotSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AreaHotSimpleConvert implements Converter
<AreaHotSimple, AreaHot> {




@Override
public AreaHotSimple convert(AreaHot source) {
AreaHotSimple result = new AreaHotSimple();

            result.setLastDate(source.getLastDate());
            if(source.getArea()!=null){
            result.setArea(source.getArea().getId());
            }
            result.setSortNum(source.getSortNum());
            result.setId(source.getId());
            if(source.getArea()!=null){
            result.setAreaName(source.getArea().getName());
            }
            result.setAddDate(source.getAddDate());


return result;
}

}