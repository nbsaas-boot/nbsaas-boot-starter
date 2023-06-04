package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserRoleCatalog;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class UserRoleCatalogEntityConvert implements Converter<UserRoleCatalog, UserRoleCatalogDataRequest> {
    @Override
    public UserRoleCatalog convert(UserRoleCatalogDataRequest source) {
        UserRoleCatalog result = new UserRoleCatalog();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

