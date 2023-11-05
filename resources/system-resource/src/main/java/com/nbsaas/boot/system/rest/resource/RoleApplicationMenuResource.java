package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.system.api.apis.RoleApplicationMenuApi;
import com.nbsaas.boot.system.data.entity.RoleApplicationMenu;
import com.nbsaas.boot.system.api.domain.request.RoleApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.request.RoleApplicationMenuSearchRequest;
import com.nbsaas.boot.system.api.domain.response.RoleApplicationMenuResponse;
import com.nbsaas.boot.system.api.domain.simple.RoleApplicationMenuSimple;
import com.nbsaas.boot.system.rest.convert.RoleApplicationMenuSimpleConvert;
import com.nbsaas.boot.system.rest.convert.RoleApplicationMenuEntityConvert;
import com.nbsaas.boot.system.rest.convert.RoleApplicationMenuResponseConvert;
import com.nbsaas.boot.system.data.repository.RoleApplicationMenuRepository;

import java.io.Serializable;
import com.nbsaas.boot.jpa.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class RoleApplicationMenuResource extends BaseResource<RoleApplicationMenu,RoleApplicationMenuResponse, RoleApplicationMenuSimple, RoleApplicationMenuDataRequest>  implements RoleApplicationMenuApi {

    @Resource
    private RoleApplicationMenuRepository roleApplicationMenuRepository;

    @Override
    public JpaRepositoryImplementation<RoleApplicationMenu, Serializable> getJpaRepository() {
        return roleApplicationMenuRepository;
    }

    @Override
    public Function<RoleApplicationMenu, RoleApplicationMenuSimple> getConvertSimple() {
        return new RoleApplicationMenuSimpleConvert();
    }

    @Override
    public Function<RoleApplicationMenuDataRequest, RoleApplicationMenu> getConvertForm() {
        return new RoleApplicationMenuEntityConvert();
    }

    @Override
    public Function<RoleApplicationMenu, RoleApplicationMenuResponse> getConvertResponse() {
    return new RoleApplicationMenuResponseConvert();
    }




}


