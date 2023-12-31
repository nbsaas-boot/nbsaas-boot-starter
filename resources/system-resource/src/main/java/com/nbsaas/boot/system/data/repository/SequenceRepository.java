package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.Sequence;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface SequenceRepository extends JpaRepositoryImplementation<Sequence, Serializable> {

}