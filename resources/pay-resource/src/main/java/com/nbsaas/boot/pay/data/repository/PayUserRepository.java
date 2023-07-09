package com.nbsaas.boot.pay.data.repository;

import com.nbsaas.boot.pay.data.entity.PayUser;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface PayUserRepository  extends  JpaRepositoryImplementation<PayUser, Serializable>{

}