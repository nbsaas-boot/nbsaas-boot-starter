package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserOauthToken;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.user.data.entity.UserOauthConfig;
            import com.nbsaas.boot.user.data.entity.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class UserOauthTokenEntityConvert  implements Converter<UserOauthToken, UserOauthTokenDataRequest> {

    @Override
    public UserOauthToken convert(UserOauthTokenDataRequest source) {
        UserOauthToken result = new UserOauthToken();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getUserOauthConfig()!=null){
                    UserOauthConfig userOauthConfig =new UserOauthConfig();
                    userOauthConfig.setId(source.getUserOauthConfig());
                    result.setUserOauthConfig(userOauthConfig);
                    }
                    if(source.getUser()!=null){
                    UserInfo user =new UserInfo();
                    user.setId(source.getUser());
                    result.setUser(user);
                    }
        return result;
    }
}

