package com.nbsaas.boot.user.data.repository;

import com.nbsaas.boot.user.data.entity.Structure;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface StructureRepository extends JpaRepositoryImplementation<Structure, Serializable> {

}