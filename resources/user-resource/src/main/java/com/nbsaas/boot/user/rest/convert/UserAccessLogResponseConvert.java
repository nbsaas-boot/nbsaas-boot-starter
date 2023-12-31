package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserAccessLog;
import com.nbsaas.boot.user.api.domain.response.UserAccessLogResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserAccessLogResponseConvert  implements Converter<UserAccessLogResponse,UserAccessLog> {

    @Override
    public UserAccessLogResponse convert(UserAccessLog source) {
        UserAccessLogResponse  result = new  UserAccessLogResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getCreator()!=null){
                        result.setCreator(source.getCreator().getId());
                    }
                    if(source.getCreator()!=null){
                        result.setCreatorName(source.getCreator().getName());
                    }
                    if(source.getStoreState()!=null){
                        result.setStoreStateName(String.valueOf(source.getStoreState()));
                    }
        return result;
    }

}

