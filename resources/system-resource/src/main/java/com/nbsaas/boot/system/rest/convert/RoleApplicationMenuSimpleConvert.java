package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.RoleApplicationMenu;
import com.nbsaas.boot.system.api.domain.simple.RoleApplicationMenuSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class RoleApplicationMenuSimpleConvert implements Converter<RoleApplicationMenuSimple, RoleApplicationMenu> {




@Override
public RoleApplicationMenuSimple convert(RoleApplicationMenu source) {
    RoleApplicationMenuSimple result = new RoleApplicationMenuSimple();

                if(source.getRole()!=null){
                    result.setRole(source.getRole().getId());
                }
                result.setId(source.getId());
                if(source.getMenu()!=null){
                    result.setMenu(source.getMenu().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}