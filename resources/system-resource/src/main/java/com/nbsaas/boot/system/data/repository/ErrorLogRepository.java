package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.ErrorLog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface ErrorLogRepository extends JpaRepositoryImplementation<ErrorLog, Serializable> {

}