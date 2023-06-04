package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.ApplicationMenu;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface ApplicationMenuRepository extends JpaRepositoryImplementation<ApplicationMenu, Serializable> {

}