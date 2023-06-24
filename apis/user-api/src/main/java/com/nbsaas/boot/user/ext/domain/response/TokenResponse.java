package com.nbsaas.boot.user.ext.domain.response;

import java.io.Serializable;

/**
 * 通过code获取的对象
 */
public class TokenResponse implements Serializable {


    /**
     * token
     */
    private String accessToken;


    /**
     * 刷新token
     */
    private String refreshToken;

    /**
     * token类型
     */
    private String tokenType;

    /**
     * 过期时间
     */
    private Integer expiresIn;

    /**
     * 权限范围
     */
    private String scope;

    /**
     * openid
     */
    private String openId;

    /**
     * 统一id
     */
    private String unionid;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
