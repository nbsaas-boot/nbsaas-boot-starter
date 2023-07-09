package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.PayConfig;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface PayConfigRepository  extends  JpaRepositoryImplementation<PayConfig, Serializable>{

}