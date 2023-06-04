package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.user.data.entity.UserPassword;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 实体对象转化成响应对象
 */

public class UserPasswordResponseConvert implements Converter
        <UserPasswordResponse, UserPassword> {

    @Override
    public UserPasswordResponse convert(UserPassword source) {
        UserPasswordResponse result = new UserPasswordResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        return result;
    }

}

