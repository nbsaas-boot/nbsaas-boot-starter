package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.jpa.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.MockApi;
import com.nbsaas.boot.system.api.domain.request.MockDataRequest;
import com.nbsaas.boot.system.api.domain.response.MockResponse;
import com.nbsaas.boot.system.api.domain.simple.MockSimple;
import com.nbsaas.boot.system.data.entity.Mock;
import com.nbsaas.boot.system.data.repository.MockRepository;
import com.nbsaas.boot.system.rest.convert.MockEntityConvert;
import com.nbsaas.boot.system.rest.convert.MockResponseConvert;
import com.nbsaas.boot.system.rest.convert.MockSimpleConvert;
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
public class MockResource extends BaseResource<Mock, MockResponse, MockSimple, MockDataRequest> implements MockApi {

    @Resource
    private MockRepository mockRepository;

    @Override
    public JpaRepositoryImplementation<Mock, Serializable> getJpaRepository() {
        return mockRepository;
    }

    @Override
    public Function<Mock, MockSimple> getConvertSimple() {
        return new MockSimpleConvert();
    }

    @Override
    public Function
            <MockDataRequest, Mock> getConvertForm() {
        return new MockEntityConvert();
    }

    @Override
    public Function<Mock, MockResponse> getConvertResponse() {
        return new MockResponseConvert();
    }

}


