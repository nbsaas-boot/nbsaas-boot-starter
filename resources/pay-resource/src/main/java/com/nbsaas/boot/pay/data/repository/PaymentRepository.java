package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.Payment;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface PaymentRepository  extends  JpaRepositoryImplementation<Payment, Serializable>{

    Payment findByPayNo(String outTradeNo);
}