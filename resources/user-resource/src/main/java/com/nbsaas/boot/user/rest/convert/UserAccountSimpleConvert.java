package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserAccountSimple;
import com.nbsaas.boot.user.data.entity.UserAccount;

/**
 * 列表对象转换器
 */

public class UserAccountSimpleConvert implements Converter
        <UserAccountSimple, UserAccount> {


    @Override
    public UserAccountSimple convert(UserAccount source) {
        UserAccountSimple result = new UserAccountSimple();

        result.setAccountType(source.getAccountType());
        result.setId(source.getId());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setAddDate(source.getAddDate());
        result.setUsername(source.getUsername());
        result.setLoginSize(source.getLoginSize());
        result.setLastDate(source.getLastDate());


        return result;
    }

}