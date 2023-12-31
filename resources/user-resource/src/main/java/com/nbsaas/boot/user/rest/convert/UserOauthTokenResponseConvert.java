package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserOauthToken;
import com.nbsaas.boot.user.api.domain.response.UserOauthTokenResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserOauthTokenResponseConvert  implements Converter<UserOauthTokenResponse,UserOauthToken> {

    @Override
    public UserOauthTokenResponse convert(UserOauthToken source) {
        UserOauthTokenResponse  result = new  UserOauthTokenResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getUserOauthConfig()!=null){
                        result.setUserOauthConfig(source.getUserOauthConfig().getId());
                    }
                    if(source.getUser()!=null){
                        result.setUser(source.getUser().getId());
                    }
        return result;
    }

}

