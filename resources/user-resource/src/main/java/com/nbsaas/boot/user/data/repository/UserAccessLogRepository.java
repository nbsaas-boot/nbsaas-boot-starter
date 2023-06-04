package com.nbsaas.boot.user.data.repository;

import com.nbsaas.boot.user.data.entity.UserAccessLog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface UserAccessLogRepository extends JpaRepositoryImplementation<UserAccessLog, Serializable> {

}