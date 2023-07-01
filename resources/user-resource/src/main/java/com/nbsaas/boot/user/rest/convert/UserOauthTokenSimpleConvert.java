package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserOauthToken;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserOauthTokenSimpleConvert implements Converter<UserOauthTokenSimple, UserOauthToken> {




@Override
public UserOauthTokenSimple convert(UserOauthToken source) {
    UserOauthTokenSimple result = new UserOauthTokenSimple();

                result.setUnionId(source.getUnionId());
                result.setOpenId(source.getOpenId());
                if(source.getUserOauthConfig()!=null){
                    result.setUserOauthConfig(source.getUserOauthConfig().getId());
                }
                result.setId(source.getId());
                result.setAccessToken(source.getAccessToken());
                result.setTokenType(source.getTokenType());
                if(source.getUser()!=null){
                    result.setUser(source.getUser().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setExpiresTime(source.getExpiresTime());
                result.setRefreshToken(source.getRefreshToken());
                result.setLoginSize(source.getLoginSize());
                result.setLastDate(source.getLastDate());


    return result;
}

}