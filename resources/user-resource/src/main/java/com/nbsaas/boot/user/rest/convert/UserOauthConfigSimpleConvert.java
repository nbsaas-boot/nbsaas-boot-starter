package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.boot.user.data.entity.UserOauthConfig;
/**
 * 列表对象转换器
 */

public class UserOauthConfigSimpleConvert implements Converter
        <UserOauthConfigSimple, UserOauthConfig> {


    @Override
    public UserOauthConfigSimple convert(UserOauthConfig source) {
        UserOauthConfigSimple result = new UserOauthConfigSimple();

        result.setLastDate(source.getLastDate());
        result.setState(source.getState());
        result.setName(source.getName());
        result.setClassName(source.getClassName());
        result.setId(source.getId());
        result.setModel(source.getModel());
        result.setAppSecret(source.getAppSecret());
        result.setAppKey(source.getAppKey());
        result.setAddDate(source.getAddDate());


        return result;
    }

}