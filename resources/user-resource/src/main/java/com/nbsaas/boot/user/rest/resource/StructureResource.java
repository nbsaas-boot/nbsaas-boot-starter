package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.user.api.apis.StructureApi;
import com.nbsaas.boot.user.data.entity.Structure;
import com.nbsaas.boot.user.api.domain.request.StructureDataRequest;
import com.nbsaas.boot.user.api.domain.request.StructureSearchRequest;
import com.nbsaas.boot.user.api.domain.response.StructureResponse;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;
import com.nbsaas.boot.user.rest.convert.StructureSimpleConvert;
import com.nbsaas.boot.user.rest.convert.StructureEntityConvert;
import com.nbsaas.boot.user.rest.convert.StructureResponseConvert;
import com.nbsaas.boot.user.data.repository.StructureRepository;

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
public class StructureResource extends BaseResource<Structure,StructureResponse, StructureSimple, StructureDataRequest>  implements StructureApi {

    @Resource
    private StructureRepository structureRepository;

    @Override
    public JpaRepositoryImplementation<Structure, Serializable> getJpaRepository() {
        return structureRepository;
    }

    @Override
    public Function<Structure, StructureSimple> getConvertSimple() {
        return new StructureSimpleConvert();
    }

    @Override
    public Function<StructureDataRequest, Structure> getConvertForm() {
        return new StructureEntityConvert();
    }

    @Override
    public Function<Structure, StructureResponse> getConvertResponse() {
    return new StructureResponseConvert();
    }



    @Override
    public ListResponse<StructureSimple> list(PageRequest request) {
        StructureSimpleConvert convert=new StructureSimpleConvert();
        if (request instanceof StructureSearchRequest){
             StructureSearchRequest searchRequest=(StructureSearchRequest)request;
             convert.setFetch(searchRequest.getFetch());
        }
        return listSimple(request,convert);
    }

}


