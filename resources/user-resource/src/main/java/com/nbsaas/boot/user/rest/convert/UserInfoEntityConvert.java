package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.data.entity.Structure;
import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class UserInfoEntityConvert implements Converter<UserInfo, UserInfoDataRequest> {

    @Override
    public UserInfo convert(UserInfoDataRequest source) {
        UserInfo result = new UserInfo();
        BeanDataUtils.copyProperties(source, result);
        if (source.getStructure() != null) {
            Structure structure = new Structure();
            structure.setId(source.getStructure());
            result.setStructure(structure);
        }
        return result;
    }
}

