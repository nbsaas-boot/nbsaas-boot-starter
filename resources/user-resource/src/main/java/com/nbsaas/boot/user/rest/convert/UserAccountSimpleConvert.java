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

        result.setUsername(source.getUsername());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setLastDate(source.getLastDate());
        result.setLoginSize(source.getLoginSize());
        result.setId(source.getId());
        result.setAccountType(source.getAccountType());
        result.setAddDate(source.getAddDate());


        return result;
    }

}