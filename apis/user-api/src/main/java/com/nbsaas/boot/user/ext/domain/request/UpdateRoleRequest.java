package com.nbsaas.boot.user.ext.domain.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateRoleRequest {

    private Long user;

    private Long role;

    private List<Long> roles;
}
