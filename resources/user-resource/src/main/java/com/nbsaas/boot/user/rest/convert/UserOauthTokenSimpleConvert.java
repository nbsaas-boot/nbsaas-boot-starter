package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserOauthToken;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserOauthTokenSimpleConvert implements Converter
<UserOauthTokenSimple, UserOauthToken> {




@Override
public UserOauthTokenSimple convert(UserOauthToken source) {
UserOauthTokenSimple result = new UserOauthTokenSimple();

            result.setExpires_in(source.getExpires_in());
            if(source.getUser()!=null){
            result.setUser(source.getUser().getId());
            }
            result.setLastDate(source.getLastDate());
            result.setToken_type(source.getToken_type());
            result.setLoginSize(source.getLoginSize());
            result.setId(source.getId());
            result.setUid(source.getUid());
            result.setRefresh_token(source.getRefresh_token());
            result.setAccess_token(source.getAccess_token());
            result.setAddDate(source.getAddDate());


return result;
}

}