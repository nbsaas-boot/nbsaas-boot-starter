package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.Mock;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface MockRepository extends JpaRepositoryImplementation<Mock, Serializable> {

}