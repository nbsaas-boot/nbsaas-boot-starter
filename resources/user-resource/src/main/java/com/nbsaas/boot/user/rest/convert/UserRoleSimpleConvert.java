package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserRole;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
 * 列表对象转换器
 */

public class UserRoleSimpleConvert implements Converter
        <UserRoleSimple, UserRole> {


    @Override
    public UserRoleSimple convert(UserRole source) {
        UserRoleSimple result = new UserRoleSimple();

        result.setLastDate(source.getLastDate());
        result.setAlias(source.getAlias());
        result.setDescription(source.getDescription());
        if (source.getCatalog() != null) {
            result.setCatalogName(source.getCatalog().getName());
        }
        if (source.getCatalog() != null) {
            result.setCatalog(source.getCatalog().getId());
        }
        result.setName(source.getName());
        result.setId(source.getId());
        result.setType(source.getType());
        result.setAddDate(source.getAddDate());


        return result;
    }

}