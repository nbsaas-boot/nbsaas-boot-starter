package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.RoleApi;
import com.nbsaas.boot.system.api.domain.request.RoleDataRequest;
import com.nbsaas.boot.system.api.domain.response.RoleResponse;
import com.nbsaas.boot.system.api.domain.simple.RoleSimple;
import com.nbsaas.boot.system.data.entity.Role;
import com.nbsaas.boot.system.data.repository.RoleRepository;
import com.nbsaas.boot.system.rest.convert.RoleEntityConvert;
import com.nbsaas.boot.system.rest.convert.RoleResponseConvert;
import com.nbsaas.boot.system.rest.convert.RoleSimpleConvert;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class RoleResource extends BaseResource<Role, RoleResponse, RoleSimple, RoleDataRequest> implements RoleApi {

    @Resource
    private RoleRepository roleRepository;

    @Override
    public JpaRepositoryImplementation<Role, Serializable> getJpaRepository() {
        return roleRepository;
    }

    @Override
    public Function<Role, RoleSimple> getConvertSimple() {
        return new RoleSimpleConvert();
    }

    @Override
    public Function
            <RoleDataRequest, Role> getConvertForm() {
        return new RoleEntityConvert();
    }

    @Override
    public Function<Role, RoleResponse> getConvertResponse() {
        return new RoleResponseConvert();
    }

}


