package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.MenuApi;
import com.nbsaas.boot.system.api.domain.request.MenuDataRequest;
import com.nbsaas.boot.system.api.domain.response.MenuResponse;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import com.nbsaas.boot.system.data.entity.Menu;
import com.nbsaas.boot.system.data.repository.MenuRepository;
import com.nbsaas.boot.system.rest.convert.MenuEntityConvert;
import com.nbsaas.boot.system.rest.convert.MenuResponseConvert;
import com.nbsaas.boot.system.rest.convert.MenuSimpleConvert;
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
public class MenuResource extends BaseResource<Menu, MenuResponse, MenuSimple, MenuDataRequest> implements MenuApi {

    @Resource
    private MenuRepository menuRepository;

    @Override
    public JpaRepositoryImplementation<Menu, Serializable> getJpaRepository() {
        return menuRepository;
    }

    @Override
    public Function<Menu, MenuSimple> getConvertSimple() {
        return new MenuSimpleConvert();
    }

    @Override
    public Function
            <MenuDataRequest, Menu> getConvertForm() {
        return new MenuEntityConvert();
    }

    @Override
    public Function<Menu, MenuResponse> getConvertResponse() {
        return new MenuResponseConvert();
    }

}


