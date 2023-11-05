package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.RoleApplicationMenu;
import com.nbsaas.boot.system.api.domain.request.RoleApplicationMenuDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.system.data.entity.Role;
            import com.nbsaas.boot.system.data.entity.ApplicationMenu;

/**
* 请求对象转换成实体对象
*/

public class RoleApplicationMenuEntityConvert  implements Converter<RoleApplicationMenu, RoleApplicationMenuDataRequest> {

    @Override
    public RoleApplicationMenu convert(RoleApplicationMenuDataRequest source) {
        RoleApplicationMenu result = new RoleApplicationMenu();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getRole()!=null){
                    Role role =new Role();
                    role.setId(source.getRole());
                    result.setRole(role);
                    }
                    if(source.getMenu()!=null){
                    ApplicationMenu menu =new ApplicationMenu();
                    menu.setId(source.getMenu());
                    result.setMenu(menu);
                    }
        return result;
    }
}

