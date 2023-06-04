package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;
import com.nbsaas.boot.user.data.entity.Structure;
import lombok.Data;

import java.util.stream.Collectors;

/**
 * 列表对象转换器
 */

@Data
public class StructureSimpleConvert implements Converter
        <StructureSimple, Structure> {


    private int fetch;


    @Override
    public StructureSimple convert(Structure source) {
        StructureSimple result = new StructureSimple();

        result.setLastDate(source.getLastDate());
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        result.setSortNum(source.getSortNum());
        result.setId(source.getId());
        result.setCode(source.getCode());
        result.setLft(source.getLft());
        result.setRgt(source.getRgt());
        result.setDepth(source.getDepth());
        result.setName(source.getName());
        if (source.getParent() != null) {
            result.setParentName(source.getParent().getName());
        }
        result.setIds(source.getIds());
        result.setAddDate(source.getAddDate());

        result.setLabel(source.getName());
        result.setValue("" + source.getId());
        if (source.getChildren() != null && source.getChildren().size() > 0) {
            if (fetch != 0) {
                result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
            }
        }

        return result;
    }

}