package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.data.entity.Ad;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class AdSimpleConvert implements Converter
<AdSimple, Ad> {




@Override
public AdSimple convert(Ad source) {
AdSimple result = new AdSimple();

            result.setLastDate(source.getLastDate());
            if(source.getAdPosition()!=null){
            result.setAdPositionName(source.getAdPosition().getName());
            }
            result.setPath(source.getPath());
            result.setBeginDate(source.getBeginDate());
            result.setBussId(source.getBussId());
            result.setNote(source.getNote());
            result.setCatalog(source.getCatalog());
            result.setAddDate(source.getAddDate());
            result.setSortNum(source.getSortNum());
            if(source.getAdPosition()!=null){
            result.setAdPosition(source.getAdPosition().getId());
            }
            result.setId(source.getId());
            result.setUrl(source.getUrl());
            result.setTitle(source.getTitle());
            result.setEndDate(source.getEndDate());


return result;
}

}