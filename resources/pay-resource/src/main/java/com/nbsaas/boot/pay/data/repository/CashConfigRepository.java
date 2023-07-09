package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.CashConfig;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface CashConfigRepository  extends  JpaRepositoryImplementation<CashConfig, Serializable>{

}