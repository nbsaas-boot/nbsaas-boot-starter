package com.nbsaas.boot.user.data.repository;

import com.nbsaas.boot.user.data.entity.UserRoleCatalog;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface UserRoleCatalogRepository extends JpaRepositoryImplementation<UserRoleCatalog, Serializable> {

}