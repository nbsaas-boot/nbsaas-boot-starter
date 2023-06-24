package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogDataRequest;
import com.nbsaas.boot.user.data.entity.UserAccessLog;
import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class UserAccessLogEntityConvert implements Converter<UserAccessLog, UserAccessLogDataRequest> {

    @Override
    public UserAccessLog convert(UserAccessLogDataRequest source) {
        UserAccessLog result = new UserAccessLog();
        BeanDataUtils.copyProperties(source, result);
        if (source.getCreator() != null) {
            UserInfo creator = new UserInfo();
            creator.setId(source.getCreator());
            result.setCreator(creator);
        }
        return result;
    }
}

