package com.nbsaas.boot.user.ext.apis;


import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.ext.domain.request.UserLoginRequest;
import com.nbsaas.boot.user.ext.domain.request.UserRegisterRequest;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;

public interface UserExtApi {


    ResponseObject<Boolean> checkRegister(UserRegisterRequest request);


    /**
     * 注册功能
     *
     * @param request
     * @return
     */
    ResponseObject<UserInfoResponse> register(UserRegisterRequest request);


    ResponseObject<UserInfoExtResponse> login(UserLoginRequest request);


}