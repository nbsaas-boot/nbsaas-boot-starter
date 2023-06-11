package com.nbsaas.boot.user.ext.handler;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.nbsaas.boot.user.ext.domain.request.OauthHandler;
import com.nbsaas.boot.user.ext.domain.response.TokenResponse;
import com.nbsaas.boot.user.ext.domain.response.WeiApp;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;

/**
 * Created by ada on 2017/6/29.
 */
public class WeiAppOauthHandler implements OauthHandler {
  
  private String oauth_consumer_key;
  
  private String secret;
  
  @Override
  public void setKey(String oauth_consumer_key) {
    this.oauth_consumer_key = oauth_consumer_key;
  }
  
  @Override
  public void setSecret(String secret) {
    this.secret = secret;
  }
  
  @Override
  public WeiApp login(String access_token, String openid) {
    WeiApp weixin = null;
    try {
      Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/jscode2session");
      con.data("js_code", access_token);
      con.data("appid", oauth_consumer_key);
      con.data("secret", secret);
      con.data("grant_type", "authorization_code");
      String body;
      body = con.execute().body();
      Gson gson = new Gson();
      weixin = gson.fromJson(body, WeiApp.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return weixin;
    
  }
  
  @Override
  public TokenResponse getToken(String code) {
    TokenResponse result = new TokenResponse();
    try {
      Connection con = HttpConnection.connect("https://api.weixin.qq.com/sns/jscode2session");
      con.data("js_code", code);
      con.data("appid", oauth_consumer_key);
      con.data("secret", secret);
      con.data("grant_type", "authorization_code");
      String body;
      body = con.execute().body();
      JsonParser parser = new JsonParser();
      JsonElement element = parser.parse(body);
      result.setAccessToken(ElementUtils.getString(element, "session_key"));
      result.setRefreshToken(ElementUtils.getString(element, "refresh_token"));
      result.setTokenType("weiapp");
      result.setExpiresIn(ElementUtils.getInt(element, "expires_in"));
      result.setOpenId(ElementUtils.getString(element, "openid"));
      result.setUnionid(ElementUtils.getString(element, "unionid"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
