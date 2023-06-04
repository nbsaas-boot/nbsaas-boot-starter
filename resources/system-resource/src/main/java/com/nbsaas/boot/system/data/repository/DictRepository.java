package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.Dict;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface DictRepository extends JpaRepositoryImplementation<Dict, Serializable> {

}