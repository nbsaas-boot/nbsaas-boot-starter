package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserAccessLogSimple;
import com.nbsaas.boot.user.data.entity.UserAccessLog;
/**
 * 列表对象转换器
 */

public class UserAccessLogSimpleConvert implements Converter
        <UserAccessLogSimple, UserAccessLog> {


    @Override
    public UserAccessLogSimple convert(UserAccessLog source) {
        UserAccessLogSimple result = new UserAccessLogSimple();

        result.setLastDate(source.getLastDate());
        result.setId(source.getId());
        result.setStoreState(source.getStoreState());
        result.setUrl(source.getUrl());
        result.setIp(source.getIp());
        if (source.getCreator() != null) {
            result.setCreator(source.getCreator().getId());
        }
        if (source.getCreator() != null) {
            result.setCreatorName(source.getCreator().getName());
        }
        result.setConsumeTime(source.getConsumeTime());
        result.setAddDate(source.getAddDate());


        return result;
    }

}