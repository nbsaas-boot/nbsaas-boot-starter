package com.nbsaas.boot.area.rest.resource;

import com.nbsaas.boot.area.api.apis.AreaApi;
import com.nbsaas.boot.area.api.domain.request.AreaDataRequest;
import com.nbsaas.boot.area.api.domain.response.AreaResponse;
import com.nbsaas.boot.area.api.domain.simple.AreaSimple;
import com.nbsaas.boot.area.data.entity.Area;
import com.nbsaas.boot.area.data.repository.AreaRepository;
import com.nbsaas.boot.area.rest.convert.AreaEntityConvert;
import com.nbsaas.boot.area.rest.convert.AreaResponseConvert;
import com.nbsaas.boot.area.rest.convert.AreaSimpleConvert;
import com.nbsaas.boot.jpa.data.core.BaseResource;
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
public class AreaResource extends BaseResource<Area, AreaResponse, AreaSimple, AreaDataRequest> implements AreaApi {

    @Resource
    private AreaRepository areaRepository;

    @Override
    public JpaRepositoryImplementation<Area, Serializable> getJpaRepository() {
        return areaRepository;
    }

    @Override
    public Function<Area, AreaSimple> getConvertSimple() {
        return new AreaSimpleConvert();
    }

    @Override
    public Function
            <AreaDataRequest, Area> getConvertForm() {
        return new AreaEntityConvert();
    }

    @Override
    public Function<Area, AreaResponse> getConvertResponse() {
        return new AreaResponseConvert();
    }

}


