package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.CashPaymentApi;
import com.nbsaas.boot.pay.data.entity.CashPayment;
import com.nbsaas.boot.pay.api.domain.request.CashPaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.request.CashPaymentSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.CashPaymentResponse;
import com.nbsaas.boot.pay.api.domain.simple.CashPaymentSimple;
import com.nbsaas.boot.pay.rest.convert.CashPaymentSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.CashPaymentEntityConvert;
import com.nbsaas.boot.pay.rest.convert.CashPaymentResponseConvert;
import com.nbsaas.boot.pay.data.repository.CashPaymentRepository;

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
public class CashPaymentResource extends BaseResource<CashPayment,CashPaymentResponse, CashPaymentSimple, CashPaymentDataRequest>  implements CashPaymentApi {

    @Resource
    private CashPaymentRepository cashPaymentRepository;

    @Override
    public JpaRepositoryImplementation<CashPayment, Serializable> getJpaRepository() {
        return cashPaymentRepository;
    }

    @Override
    public Function<CashPayment, CashPaymentSimple> getConvertSimple() {
        return new CashPaymentSimpleConvert();
    }

    @Override
    public Function<CashPaymentDataRequest, CashPayment> getConvertForm() {
        return new CashPaymentEntityConvert();
    }

    @Override
    public Function<CashPayment, CashPaymentResponse> getConvertResponse() {
    return new CashPaymentResponseConvert();
    }




}


