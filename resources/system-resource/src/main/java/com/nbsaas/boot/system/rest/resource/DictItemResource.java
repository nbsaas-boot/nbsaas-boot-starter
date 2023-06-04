package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.DictItemApi;
import com.nbsaas.boot.system.api.domain.request.DictItemDataRequest;
import com.nbsaas.boot.system.api.domain.response.DictItemResponse;
import com.nbsaas.boot.system.api.domain.simple.DictItemSimple;
import com.nbsaas.boot.system.data.entity.DictItem;
import com.nbsaas.boot.system.data.repository.DictItemRepository;
import com.nbsaas.boot.system.rest.convert.DictItemEntityConvert;
import com.nbsaas.boot.system.rest.convert.DictItemResponseConvert;
import com.nbsaas.boot.system.rest.convert.DictItemSimpleConvert;
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
public class DictItemResource extends BaseResource<DictItem, DictItemResponse, DictItemSimple, DictItemDataRequest> implements DictItemApi {

    @Resource
    private DictItemRepository dictItemRepository;

    @Override
    public JpaRepositoryImplementation<DictItem, Serializable> getJpaRepository() {
        return dictItemRepository;
    }

    @Override
    public Function<DictItem, DictItemSimple> getConvertSimple() {
        return new DictItemSimpleConvert();
    }

    @Override
    public Function
            <DictItemDataRequest, DictItem> getConvertForm() {
        return new DictItemEntityConvert();
    }

    @Override
    public Function<DictItem, DictItemResponse> getConvertResponse() {
        return new DictItemResponseConvert();
    }

}


