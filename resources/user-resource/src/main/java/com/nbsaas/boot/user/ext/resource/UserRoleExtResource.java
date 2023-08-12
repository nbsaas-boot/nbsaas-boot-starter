package com.nbsaas.boot.user.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.UserRoleApi;
import com.nbsaas.boot.user.api.domain.request.UserRoleDataRequest;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.boot.user.ext.apis.UserRoleExtApi;
import com.nbsaas.boot.user.ext.domain.request.UpdateRoleRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserRoleExtResource implements UserRoleExtApi {

    @Resource
    private UserRoleApi userRoleApi;

    @Transactional
    @Override
    public ResponseObject<?> updateRole(UpdateRoleRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        List<UserRoleSimple> roles = userRoleApi.listData(Filter.eq("userInfo.id", request.getUser()));
        for (UserRoleSimple role : roles) {
            userRoleApi.deleteById(role.getId());
        }

        UserRoleDataRequest form = new UserRoleDataRequest();
        form.setUserInfo(request.getUser());
        form.setRoleId(request.getRole());
        userRoleApi.createData(form);
        return result;
    }
}
