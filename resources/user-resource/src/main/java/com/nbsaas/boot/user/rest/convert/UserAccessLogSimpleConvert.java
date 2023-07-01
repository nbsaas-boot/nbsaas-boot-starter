package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserAccessLog;
import com.nbsaas.boot.user.api.domain.simple.UserAccessLogSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserAccessLogSimpleConvert implements Converter<UserAccessLogSimple, UserAccessLog> {




@Override
public UserAccessLogSimple convert(UserAccessLog source) {
    UserAccessLogSimple result = new UserAccessLogSimple();

                result.setConsumeTime(source.getConsumeTime());
                if(source.getCreator()!=null){
                    result.setCreator(source.getCreator().getId());
                }
                result.setIp(source.getIp());
                if(source.getCreator()!=null){
                    result.setCreatorName(source.getCreator().getName());
                }
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setUrl(source.getUrl());
                result.setLastDate(source.getLastDate());


    return result;
}

}