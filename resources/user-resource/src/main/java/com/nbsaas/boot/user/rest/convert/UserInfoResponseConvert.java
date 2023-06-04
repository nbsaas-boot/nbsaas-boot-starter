package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 实体对象转化成响应对象
 */

public class UserInfoResponseConvert implements Converter
        <UserInfoResponse, UserInfo> {

    @Override
    public UserInfoResponse convert(UserInfo source) {
        UserInfoResponse result = new UserInfoResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getStructure() != null) {
            result.setStructureName(source.getStructure().getName());
        }
        if (source.getStructure() != null) {
            result.setStructure(source.getStructure().getId());
        }
        return result;
    }

}

