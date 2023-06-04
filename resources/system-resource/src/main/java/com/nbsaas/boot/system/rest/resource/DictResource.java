package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.system.api.apis.DictApi;
import com.nbsaas.boot.system.data.entity.Dict;
import com.nbsaas.boot.system.api.domain.request.DictDataRequest;
import com.nbsaas.boot.system.api.domain.response.DictResponse;
import com.nbsaas.boot.system.api.domain.simple.DictSimple;
import com.nbsaas.boot.system.rest.convert.DictSimpleConvert;
import com.nbsaas.boot.system.rest.convert.DictEntityConvert;
import com.nbsaas.boot.system.rest.convert.DictResponseConvert;
import com.nbsaas.boot.system.data.repository.DictRepository;

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
public class DictResource extends BaseResource<Dict,DictResponse, DictSimple, DictDataRequest>  implements DictApi {

@Resource
private DictRepository dictRepository;

@Override
public JpaRepositoryImplementation<Dict, Serializable> getJpaRepository() {
return dictRepository;
}

@Override
public Function<Dict, DictSimple> getConvertSimple() {
return new DictSimpleConvert();
}

@Override
public Function
<DictDataRequest, Dict> getConvertForm() {
return new DictEntityConvert();
}

@Override
public Function<Dict, DictResponse> getConvertResponse() {
return new DictResponseConvert();
}

}


