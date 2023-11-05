package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.RoleApplicationMenu;
import com.nbsaas.boot.system.api.domain.response.RoleApplicationMenuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class RoleApplicationMenuResponseConvert  implements Converter<RoleApplicationMenuResponse,RoleApplicationMenu> {

    @Override
    public RoleApplicationMenuResponse convert(RoleApplicationMenu source) {
        RoleApplicationMenuResponse  result = new  RoleApplicationMenuResponse();
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

