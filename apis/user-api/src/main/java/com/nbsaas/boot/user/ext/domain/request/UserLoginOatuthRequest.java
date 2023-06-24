package com.nbsaas.boot.user.ext.domain.request;

import lombok.Data;

@Data
public class UserLoginOatuthRequest {

    /**
     * 第三方登陆类型
     */
    String type;

    /**
     * 授权码
     */
    private String code;

    private String openId;

    private Boolean replace;

    private String afterListener;

}
