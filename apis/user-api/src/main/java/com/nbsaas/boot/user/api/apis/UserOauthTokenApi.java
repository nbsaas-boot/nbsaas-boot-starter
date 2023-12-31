package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserOauthTokenResponse;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;


/**
 * 对外接口
 */
public interface UserOauthTokenApi extends BaseApi<UserOauthTokenResponse, UserOauthTokenSimple, UserOauthTokenDataRequest> {


}
