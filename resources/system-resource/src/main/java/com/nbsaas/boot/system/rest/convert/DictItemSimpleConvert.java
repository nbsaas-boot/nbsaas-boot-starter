package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.DictItem;
import com.nbsaas.boot.system.api.domain.simple.DictItemSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class DictItemSimpleConvert implements Converter
<DictItemSimple, DictItem> {




@Override
public DictItemSimple convert(DictItem source) {
DictItemSimple result = new DictItemSimple();

            if(source.getDict()!=null){
            result.setDict(source.getDict().getId());
            }
            result.setLastDate(source.getLastDate());
            result.setId(source.getId());
            result.setStoreState(source.getStoreState());

            result.setSortNum(source.getSortNum());
            result.setDataValue(source.getDataValue());
            result.setDataCode(source.getDataCode());
            result.setAddDate(source.getAddDate());


return result;
}

}