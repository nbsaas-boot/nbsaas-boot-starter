package com.nbsaas.boot.user.ext.domain.request;

import com.nbsaas.boot.rest.request.RequestObject;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PasswordRequest extends RequestObject {




    @NotEmpty(message = "密码不能为空")
    private String password;

    private String salt;

}
