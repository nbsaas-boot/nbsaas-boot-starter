package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserRole;
import com.nbsaas.boot.user.api.domain.response.UserRoleResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserRoleResponseConvert  implements Converter
<UserRoleResponse,UserRole> {

@Override
public UserRoleResponse convert(UserRole source) {
UserRoleResponse  result = new  UserRoleResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getUserInfo()!=null){
                result.setUserInfo(source.getUserInfo().getId());
            }
return result;
}

}

