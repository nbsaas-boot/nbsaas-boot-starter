package com.nbsaas.boot.user.ext.domain.request;

import com.nbsaas.boot.rest.request.RequestObject;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegisterRequest extends RequestObject {


    @NotEmpty(message = "用户名不能为空")
    private String username;


    @NotEmpty(message = "密码不能为空")
    private String password;

    private String salt;

    private String dbPassword;

    private AccountType accountType;

}
