package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserOauthConfig;
import com.nbsaas.boot.user.api.domain.response.UserOauthConfigResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserOauthConfigResponseConvert  implements Converter
<UserOauthConfigResponse,UserOauthConfig> {

@Override
public UserOauthConfigResponse convert(UserOauthConfig source) {
UserOauthConfigResponse  result = new  UserOauthConfigResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}

}

