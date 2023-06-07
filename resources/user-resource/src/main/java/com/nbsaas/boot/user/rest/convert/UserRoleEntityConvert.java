package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserRole;
import com.nbsaas.boot.user.api.domain.request.UserRoleDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.user.data.entity.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class UserRoleEntityConvert  implements Converter<UserRole, UserRoleDataRequest> {
@Override
public UserRole convert(UserRoleDataRequest source) {
UserRole result = new UserRole();
BeanDataUtils.copyProperties(source, result);
            if(source.getUserInfo()!=null){
            UserInfo userInfo =new UserInfo();
            userInfo.setId(source.getUserInfo());
            result.setUserInfo(userInfo);
            }
return result;
}
}

