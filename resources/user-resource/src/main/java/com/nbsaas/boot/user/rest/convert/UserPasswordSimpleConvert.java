package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.boot.user.data.entity.UserPassword;

/**
 * 列表对象转换器
 */

public class UserPasswordSimpleConvert implements Converter
        <UserPasswordSimple, UserPassword> {


    @Override
    public UserPasswordSimple convert(UserPassword source) {
        UserPasswordSimple result = new UserPasswordSimple();

        result.setPassword(source.getPassword());
        result.setSalt(source.getSalt());
        result.setSecurityType(source.getSecurityType());
        result.setCheckSize(source.getCheckSize());
        result.setId(source.getId());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());


        return result;
    }

}