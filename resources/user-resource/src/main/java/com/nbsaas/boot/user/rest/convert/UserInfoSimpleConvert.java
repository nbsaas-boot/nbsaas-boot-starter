package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.boot.user.data.entity.UserInfo;

/**
 * 列表对象转换器
 */

public class UserInfoSimpleConvert implements Converter
        <UserInfoSimple, UserInfo> {


    @Override
    public UserInfoSimple convert(UserInfo source) {
        UserInfoSimple result = new UserInfoSimple();

        result.setNote(source.getNote());
        result.setCatalog(source.getCatalog());
        result.setAvatar(source.getAvatar());
        result.setDataScope(source.getDataScope());
        result.setAddDate(source.getAddDate());
        if (source.getStructure() != null) {
            result.setStructure(source.getStructure().getId());
        }
        result.setLoginSize(source.getLoginSize());
        result.setPhone(source.getPhone());
        result.setName(source.getName());
        result.setStoreState(source.getStoreState());
        result.setState(source.getState());
        result.setId(source.getId());
        result.setLastDate(source.getLastDate());


        return result;
    }

}