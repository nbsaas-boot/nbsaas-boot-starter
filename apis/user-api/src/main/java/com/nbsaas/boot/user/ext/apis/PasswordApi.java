package com.nbsaas.boot.user.ext.apis;


import com.nbsaas.boot.user.ext.domain.request.PasswordRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.response.PasswordResponse;

public interface PasswordApi {


    /**
     * 生成加密后的密码
     *
     * @param request
     * @return
     */
    PasswordResponse password(PasswordRequest request);


    PasswordResponse passwordBySalt(PasswordRequest request);

}
