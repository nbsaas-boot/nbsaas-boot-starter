package com.nbsaas.boot.message.data.repository;

import com.nbsaas.boot.message.data.entity.InboxTemplate;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface InboxTemplateRepository  extends  JpaRepositoryImplementation<InboxTemplate, Serializable>{

}