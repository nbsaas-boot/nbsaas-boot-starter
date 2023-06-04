package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.RecordLog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface RecordLogRepository extends JpaRepositoryImplementation<RecordLog, Serializable> {

}