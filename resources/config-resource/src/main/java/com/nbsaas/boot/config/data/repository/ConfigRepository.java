package com.nbsaas.boot.config.data.repository;

import com.nbsaas.boot.config.data.entity.Config;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface ConfigRepository  extends  JpaRepositoryImplementation<Config, Serializable>{

    Config findByClassName(String className);
}