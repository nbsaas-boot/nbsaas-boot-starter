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

        result.setNote(source.getNote());
        result.setPassword(source.getPassword());
        result.setIp(source.getIp());
        result.setClient(source.getClient());
        result.setStoreState(source.getStoreState());
        result.setState(source.getState());
        result.setId(source.getId());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }
        result.setAddDate(source.getAddDate());
        result.setAccount(source.getAccount());
        result.setLastDate(source.getLastDate());


        return result;
    }

}