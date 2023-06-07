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

            result.setAccess_token(source.getAccess_token());
            result.setRefresh_token(source.getRefresh_token());
            result.setUid(source.getUid());
            result.setId(source.getId());
            result.setToken_type(source.getToken_type());
            result.setExpires_in(source.getExpires_in());
            if(source.getUser()!=null){
                result.setUser(source.getUser().getId());
            }
            result.setAddDate(source.getAddDate());
            result.setLoginSize(source.getLoginSize());
            result.setLastDate(source.getLastDate());


return result;
}

}