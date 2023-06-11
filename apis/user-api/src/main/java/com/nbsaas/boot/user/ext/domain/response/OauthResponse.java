package com.nbsaas.boot.user.ext.domain.response;

/**
 * Created by ada on 2017/7/20.
 */
public interface OauthResponse {
  
  /**
   * 獲取openid
   *
   * @return
   */
  String getOpenid();
  
  String getName();
  
  String getAvatar();
  
  /**
   * 类型
   *
   * @return 类型
   */
  String type();
  
}
