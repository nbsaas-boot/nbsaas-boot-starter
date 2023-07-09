package com.nbsaas.boot.pay.ext.apis;

import com.nbsaas.boot.pay.api.domain.request.CashConfigSearchRequest;
import com.nbsaas.boot.pay.ext.domain.response.CashConfigExtResponse;
import com.nbsaas.boot.pay.ext.domain.response.CashConfigExtSearchRequest;
import com.nbsaas.boot.rest.response.ResponseObject;

public interface CashConfigExtApi {

  ResponseObject<CashConfigExtResponse> config(CashConfigExtSearchRequest request);
}
