package com.nbsaas.boot.user.ext.domain.response;

/**
 * Created by ada on 2017/7/21.
 */
public class WeiApp implements OauthResponse {

  private String openid;

  private String session_key;


  private String unionid;

  public void setOpenid(String openid) {
    this.openid = openid;
  }

  public String getSession_key() {
    return session_key;
  }

  public void setSession_key(String session_key) {
    this.session_key = session_key;
  }


  @Override
  public String getOpenid() {
    return openid;
  }

  @Override
  public String getName() {
    return "";
  }

  @Override
  public String getAvatar() {
    return "";
  }

  @Override
  public String type() {
    return "weiapp";
  }

  public String getUnionid() {
    return unionid;
  }

  public void setUnionid(String unionid) {
    this.unionid = unionid;
  }
}
