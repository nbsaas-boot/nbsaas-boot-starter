package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.Config;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface ConfigRepository extends JpaRepositoryImplementation<Config, Serializable> {

}