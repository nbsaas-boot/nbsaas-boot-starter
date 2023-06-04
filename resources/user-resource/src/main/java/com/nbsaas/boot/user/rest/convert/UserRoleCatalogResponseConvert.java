package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserRoleCatalog;
import com.nbsaas.boot.user.api.domain.response.UserRoleCatalogResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
 * 实体对象转化成响应对象
 */

public class UserRoleCatalogResponseConvert implements Converter
        <UserRoleCatalogResponse, UserRoleCatalog> {

    @Override
    public UserRoleCatalogResponse convert(UserRoleCatalog source) {
        UserRoleCatalogResponse result = new UserRoleCatalogResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            result.setParentName(source.getParent().getName());
        }
        return result;
    }

}

