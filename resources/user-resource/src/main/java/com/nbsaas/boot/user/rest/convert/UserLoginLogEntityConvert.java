package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.user.data.entity.UserLoginLog;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class UserLoginLogEntityConvert implements Converter<UserLoginLog, UserLoginLogDataRequest> {
    @Override
    public UserLoginLog convert(UserLoginLogDataRequest source) {
        UserLoginLog result = new UserLoginLog();
        BeanDataUtils.copyProperties(source, result);
        if (source.getUser() != null) {
            UserInfo user = new UserInfo();
            user.setId(source.getUser());
            result.setUser(user);
        }
        return result;
    }
}

