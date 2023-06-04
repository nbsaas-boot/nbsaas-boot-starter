package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.data.entity.AdPosition;
import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AdPositionSimpleConvert implements Converter
<AdPositionSimple, AdPosition> {




@Override
public AdPositionSimple convert(AdPosition source) {
AdPositionSimple result = new AdPositionSimple();

            result.setLastDate(source.getLastDate());
            result.setSortNum(source.getSortNum());
            result.setName(source.getName());
            result.setKey(source.getKey());
            result.setId(source.getId());
            result.setHeight(source.getHeight());
            result.setNote(source.getNote());
            result.setWidth(source.getWidth());
            result.setTemplate(source.getTemplate());
            result.setAddDate(source.getAddDate());


return result;
}

}