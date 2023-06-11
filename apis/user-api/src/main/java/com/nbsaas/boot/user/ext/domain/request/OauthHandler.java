package com.nbsaas.boot.user.ext.domain.request;


import com.nbsaas.boot.user.ext.domain.response.OauthResponse;
import com.nbsaas.boot.user.ext.domain.response.TokenResponse;

/**
 * oauth登陆处理类
 * <p>
 * Created by ada on 2017/7/20.
 */
public interface OauthHandler {
  
  void setKey(String key);
  
  void setSecret(String secret);
  
  /**
   * 通过token获取用户资料
   *
   * @param access_token
   * @param openid
   * @return
   */
  OauthResponse login(String access_token, String openid);
  
  /**
   * 通过code换取令牌
   *
   * @param code
   * @return
   */
  TokenResponse getToken(String code);
  
}
