package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.DictItem;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface DictItemRepository  extends  JpaRepositoryImplementation<DictItem, Serializable>{

}