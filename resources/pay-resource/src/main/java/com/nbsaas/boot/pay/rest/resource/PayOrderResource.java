package com.nbsaas.boot.pay.rest.resource;

import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.pay.api.apis.PayOrderApi;
import com.nbsaas.boot.pay.data.entity.PayOrder;
import com.nbsaas.boot.pay.api.domain.request.PayOrderDataRequest;
import com.nbsaas.boot.pay.api.domain.request.PayOrderSearchRequest;
import com.nbsaas.boot.pay.api.domain.response.PayOrderResponse;
import com.nbsaas.boot.pay.api.domain.simple.PayOrderSimple;
import com.nbsaas.boot.pay.rest.convert.PayOrderSimpleConvert;
import com.nbsaas.boot.pay.rest.convert.PayOrderEntityConvert;
import com.nbsaas.boot.pay.rest.convert.PayOrderResponseConvert;
import com.nbsaas.boot.pay.data.repository.PayOrderRepository;

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
public class PayOrderResource extends BaseResource<PayOrder,PayOrderResponse, PayOrderSimple, PayOrderDataRequest>  implements PayOrderApi {

    @Resource
    private PayOrderRepository payOrderRepository;

    @Override
    public JpaRepositoryImplementation<PayOrder, Serializable> getJpaRepository() {
        return payOrderRepository;
    }

    @Override
    public Function<PayOrder, PayOrderSimple> getConvertSimple() {
        return new PayOrderSimpleConvert();
    }

    @Override
    public Function<PayOrderDataRequest, PayOrder> getConvertForm() {
        return new PayOrderEntityConvert();
    }

    @Override
    public Function<PayOrder, PayOrderResponse> getConvertResponse() {
    return new PayOrderResponseConvert();
    }




}


