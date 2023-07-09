package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.CashPayment;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface CashPaymentRepository  extends  JpaRepositoryImplementation<CashPayment, Serializable>{

}