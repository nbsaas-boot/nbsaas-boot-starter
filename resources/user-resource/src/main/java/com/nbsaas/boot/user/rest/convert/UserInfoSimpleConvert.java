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

        result.setLastDate(source.getLastDate());
        result.setState(source.getState());
        if (source.getStructure() != null) {
            result.setStructureName(source.getStructure().getName());
        }
        result.setNote(source.getNote());
        result.setPhone(source.getPhone());
        result.setCatalog(source.getCatalog());
        result.setDataScope(source.getDataScope());
        result.setAddDate(source.getAddDate());
        result.setAvatar(source.getAvatar());
        if (source.getStructure() != null) {
            result.setStructure(source.getStructure().getId());
        }
        result.setLoginSize(source.getLoginSize());
        result.setName(source.getName());
        result.setId(source.getId());
        result.setStoreState(source.getStoreState());


        return result;
    }

}