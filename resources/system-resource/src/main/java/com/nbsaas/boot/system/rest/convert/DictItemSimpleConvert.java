package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.simple.DictItemSimple;
import com.nbsaas.boot.system.data.entity.DictItem;

/**
 * 列表对象转换器
 */

public class DictItemSimpleConvert implements Converter
        <DictItemSimple, DictItem> {


    @Override
    public DictItemSimple convert(DictItem source) {
        DictItemSimple result = new DictItemSimple();

        result.setDataValue(source.getDataValue());
        if (source.getDict() != null) {
            result.setDict(source.getDict().getId());
        }
        result.setSortNum(source.getSortNum());
        result.setStoreState(source.getStoreState());
        result.setId(source.getId());
        result.setDataCode(source.getDataCode());
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());


        return result;
    }

}