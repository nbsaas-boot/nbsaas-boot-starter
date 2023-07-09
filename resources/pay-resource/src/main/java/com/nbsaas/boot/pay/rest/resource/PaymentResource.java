package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.PaymentApi;
import com.nbsaas.boot.pay.data.entity.Payment;
import com.nbsaas.boot.pay.api.domain.request.PaymentDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PaymentSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;
import com.nbsaas.boot.pay.api.domain.simple.PaymentSimple;
import com.nbsaas.boot.pay.rest.convert.PaymentSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.PaymentEntityConvert;
import com.nbsaas.boot.pay.rest.convert.PaymentResponseConvert;
import com.nbsaas.boot.pay.data.repository.PaymentRepository;

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
public class PaymentResource extends BaseResource<Payment,PaymentResponse, PaymentSimple, PaymentDataRequest>  implements PaymentApi {

    @Resource
    private PaymentRepository paymentRepository;

    @Override
    public JpaRepositoryImplementation<Payment, Serializable> getJpaRepository() {
        return paymentRepository;
    }

    @Override
    public Function<Payment, PaymentSimple> getConvertSimple() {
        return new PaymentSimpleConvert();
    }

    @Override
    public Function<PaymentDataRequest, Payment> getConvertForm() {
        return new PaymentEntityConvert();
    }

    @Override
    public Function<Payment, PaymentResponse> getConvertResponse() {
    return new PaymentResponseConvert();
    }




}


