package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.TenantAccountApi;
import com.nbsaas.boot.pay.data.entity.TenantAccount;
import com.nbsaas.boot.pay.api.domain.request.TenantAccountDataRequest;
import com.nbsaas.boot.pay.api.domain.request.TenantAccountSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.TenantAccountResponse;
import com.nbsaas.boot.pay.api.domain.simple.TenantAccountSimple;
import com.nbsaas.boot.pay.rest.convert.TenantAccountSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.TenantAccountEntityConvert;
import com.nbsaas.boot.pay.rest.convert.TenantAccountResponseConvert;
import com.nbsaas.boot.pay.data.repository.TenantAccountRepository;

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
public class TenantAccountResource extends BaseResource<TenantAccount,TenantAccountResponse, TenantAccountSimple, TenantAccountDataRequest>  implements TenantAccountApi {

    @Resource
    private TenantAccountRepository tenantAccountRepository;

    @Override
    public JpaRepositoryImplementation<TenantAccount, Serializable> getJpaRepository() {
        return tenantAccountRepository;
    }

    @Override
    public Function<TenantAccount, TenantAccountSimple> getConvertSimple() {
        return new TenantAccountSimpleConvert();
    }

    @Override
    public Function<TenantAccountDataRequest, TenantAccount> getConvertForm() {
        return new TenantAccountEntityConvert();
    }

    @Override
    public Function<TenantAccount, TenantAccountResponse> getConvertResponse() {
    return new TenantAccountResponseConvert();
    }




}


