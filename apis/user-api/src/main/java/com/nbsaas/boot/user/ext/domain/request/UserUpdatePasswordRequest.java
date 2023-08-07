package com.nbsaas.boot.user.ext.domain.request;

import com.nbsaas.boot.rest.request.RequestObject;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 修改密码请求
 */
@Data
public class UserUpdatePasswordRequest extends RequestObject {

    private Long id;

    @NotEmpty(message = "老密码不能为空")
    private String oldPassword;

    @NotEmpty(message = "心密码不能为空")
    private String password;
}
