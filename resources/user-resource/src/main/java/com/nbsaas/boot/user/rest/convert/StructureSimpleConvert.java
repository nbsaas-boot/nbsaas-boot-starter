package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.Structure;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;

import com.nbsaas.boot.rest.api.Converter;
    import java.util.stream.Collectors;
    import lombok.Data;
/**
* 列表对象转换器
*/

    @Data
public class StructureSimpleConvert implements Converter<StructureSimple, Structure> {


    private int fetch;


@Override
public StructureSimple convert(Structure source) {
    StructureSimple result = new StructureSimple();

                if(source.getParent()!=null){
                    result.setParent(source.getParent().getId());
                }
                if(source.getParent()!=null){
                    result.setParentName(source.getParent().getName());
                }
                result.setCode(source.getCode());
                result.setDepth(source.getDepth());
                result.setName(source.getName());
                result.setIds(source.getIds());
                result.setSortNum(source.getSortNum());
                result.setId(source.getId());
                result.setLft(source.getLft());
                result.setAddDate(source.getAddDate());
                result.setRgt(source.getRgt());
                result.setLastDate(source.getLastDate());

        result.setLabel(source.getName());
        result.setValue(""+source.getId());
        if (source.getChildren()!=null&&source.getChildren().size()>0){
            if (fetch!=0){
                result.setChildren(source.getChildren().stream().map(this).collect(Collectors.toList()));
            }
            result.setHasChildren(true);
        }else{
            result.setHasChildren(false);
        }

    return result;
}

}