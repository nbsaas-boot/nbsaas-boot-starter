package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.PayOrder;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface PayOrderRepository  extends  JpaRepositoryImplementation<PayOrder, Serializable>{

}