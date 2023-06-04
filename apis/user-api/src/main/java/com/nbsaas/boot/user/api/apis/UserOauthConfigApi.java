package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.user.api.domain.request.UserOauthConfigDataRequest;
import com.nbsaas.boot.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.boot.user.api.domain.response.UserOauthConfigResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
 * 对外接口
 */
public interface UserOauthConfigApi extends BaseApi<UserOauthConfigResponse, UserOauthConfigSimple, UserOauthConfigDataRequest> {


}
