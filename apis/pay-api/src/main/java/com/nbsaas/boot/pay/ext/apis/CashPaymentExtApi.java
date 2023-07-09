package com.nbsaas.boot.pay.ext.apis;

import com.nbsaas.boot.pay.api.domain.request.CashPaymentDataRequest;
import com.nbsaas.boot.pay.ext.domain.request.WithdrawalRequest;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface CashPaymentExtApi {

    /**
     * 自动提现功能
     *
     * @param request
     * @return
     */
    ResponseObject<Long> cashAuto(WithdrawalRequest request);


    /**
     * 资金退回
     *
     * @param request
     * @return
     */
    ResponseObject<?> back(CashPaymentDataRequest request);

}
