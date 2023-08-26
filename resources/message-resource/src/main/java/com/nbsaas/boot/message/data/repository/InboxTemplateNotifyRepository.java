package com.nbsaas.boot.message.data.repository;

import com.nbsaas.boot.message.data.entity.InboxTemplateNotify;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface InboxTemplateNotifyRepository  extends  JpaRepositoryImplementation<InboxTemplateNotify, Serializable>{

}