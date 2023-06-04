package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import com.nbsaas.boot.system.data.entity.Menu;
import lombok.Data;

import java.util.stream.Collectors;

/**
 * 列表对象转换器
 */

@Data
public class MenuSimpleConvert implements Converter
        <MenuSimple, Menu> {


    private int fetch;


    @Override
    public MenuSimple convert(Menu source) {
        MenuSimple result = new MenuSimple();

        result.setLastDate(source.getLastDate());
        result.setIcon(source.getIcon());
        result.setNums(source.getNums());
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        result.setPath(source.getPath());
        result.setCode(source.getCode());
        result.setLft(source.getLft());
        result.setDepth(source.getDepth());
        result.setPermission(source.getPermission());
        result.setAddDate(source.getAddDate());
        result.setSortNum(source.getSortNum());
        result.setRouter(source.getRouter());
        result.setId(source.getId());
        result.setCatalog(source.getCatalog());
        result.setMenuType(source.getMenuType());
        result.setRgt(source.getRgt());
        result.setName(source.getName());
        result.setIds(source.getIds());

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