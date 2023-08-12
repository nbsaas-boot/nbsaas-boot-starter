package com.nbsaas.boot.user.ext.domain.request;

import com.nbsaas.boot.rest.request.RequestObject;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 修改密码请求
 */
@Data
public class UserResetPasswordRequest extends RequestObject {

    private Long id;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
