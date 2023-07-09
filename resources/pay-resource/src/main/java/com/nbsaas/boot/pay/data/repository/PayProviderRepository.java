package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.PayProvider;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface PayProviderRepository  extends  JpaRepositoryImplementation<PayProvider, Serializable>{

}