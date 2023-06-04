package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.Application;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface ApplicationRepository extends JpaRepositoryImplementation<Application, Serializable> {

}