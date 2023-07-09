package com.nbsaas.boot.pay.ext.apis;


import com.nbsaas.boot.pay.api.domain.response.PaymentResponse;

public interface PayHandler {

  void pay(PaymentResponse payment);
}
