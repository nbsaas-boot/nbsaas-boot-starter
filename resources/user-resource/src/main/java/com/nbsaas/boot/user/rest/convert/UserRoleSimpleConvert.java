package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserRole;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserRoleSimpleConvert implements Converter<UserRoleSimple, UserRole> {




@Override
public UserRoleSimple convert(UserRole source) {
    UserRoleSimple result = new UserRoleSimple();

                if(source.getUserInfo()!=null){
                    result.setUserInfo(source.getUserInfo().getId());
                }
                result.setRoleId(source.getRoleId());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}