package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.TenantAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TenantAccountRepository  extends  JpaRepositoryImplementation<TenantAccount, Serializable>{

}