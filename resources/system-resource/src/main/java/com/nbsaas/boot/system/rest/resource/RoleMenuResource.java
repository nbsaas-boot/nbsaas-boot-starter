package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.system.api.apis.RoleMenuApi;
import com.nbsaas.boot.system.data.entity.RoleMenu;
import com.nbsaas.boot.system.api.domain.request.RoleMenuDataRequest;
import com.nbsaas.boot.system.api.domain.response.RoleMenuResponse;
import com.nbsaas.boot.system.api.domain.simple.RoleMenuSimple;
import com.nbsaas.boot.system.rest.convert.RoleMenuSimpleConvert;
import com.nbsaas.boot.system.rest.convert.RoleMenuEntityConvert;
import com.nbsaas.boot.system.rest.convert.RoleMenuResponseConvert;
import com.nbsaas.boot.system.data.repository.RoleMenuRepository;

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
public class RoleMenuResource extends BaseResource<RoleMenu,RoleMenuResponse, RoleMenuSimple, RoleMenuDataRequest>  implements RoleMenuApi {

@Resource
private RoleMenuRepository roleMenuRepository;

@Override
public JpaRepositoryImplementation<RoleMenu, Serializable> getJpaRepository() {
return roleMenuRepository;
}

@Override
public Function<RoleMenu, RoleMenuSimple> getConvertSimple() {
return new RoleMenuSimpleConvert();
}

@Override
public Function
<RoleMenuDataRequest, RoleMenu> getConvertForm() {
return new RoleMenuEntityConvert();
}

@Override
public Function<RoleMenu, RoleMenuResponse> getConvertResponse() {
return new RoleMenuResponseConvert();
}

}


