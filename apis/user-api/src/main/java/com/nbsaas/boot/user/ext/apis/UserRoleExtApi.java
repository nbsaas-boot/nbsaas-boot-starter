package com.nbsaas.boot.user.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.ext.domain.request.UpdateRoleRequest;

public interface UserRoleExtApi {

    ResponseObject<?> updateRole(UpdateRoleRequest request);
}
