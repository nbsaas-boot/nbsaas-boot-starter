package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.boot.user.data.entity.UserLoginLog;

/**
 * 列表对象转换器
 */

public class UserLoginLogSimpleConvert implements Converter
        <UserLoginLogSimple, UserLoginLog> {


    @Override
    public UserLoginLogSimple convert(UserLoginLog source) {
        UserLoginLogSimple result = new UserLoginLogSimple();

        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setState(source.getState());
        result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        result.setStoreState(source.getStoreState());
        result.setClient(source.getClient());
        result.setNote(source.getNote());
        result.setAccount(source.getAccount());
        result.setIp(source.getIp());
        if (source.getUser() != null) {
            result.setUserName(source.getUser().getName());
        }
        result.setPassword(source.getPassword());
        result.setAddDate(source.getAddDate());


        return result;
    }

}