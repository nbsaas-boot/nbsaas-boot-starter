package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.RoleMenu;
import com.nbsaas.boot.system.api.domain.simple.RoleMenuSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class RoleMenuSimpleConvert implements Converter
<RoleMenuSimple, RoleMenu> {




@Override
public RoleMenuSimple convert(RoleMenu source) {
RoleMenuSimple result = new RoleMenuSimple();

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