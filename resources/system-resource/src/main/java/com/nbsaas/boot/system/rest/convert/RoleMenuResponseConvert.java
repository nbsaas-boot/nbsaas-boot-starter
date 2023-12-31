package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.RoleMenu;
import com.nbsaas.boot.system.api.domain.response.RoleMenuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class RoleMenuResponseConvert  implements Converter<RoleMenuResponse,RoleMenu> {

    @Override
    public RoleMenuResponse convert(RoleMenu source) {
        RoleMenuResponse  result = new  RoleMenuResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getRole()!=null){
                        result.setRole(source.getRole().getId());
                    }
                    if(source.getMenu()!=null){
                        result.setMenu(source.getMenu().getId());
                    }
        return result;
    }

}

