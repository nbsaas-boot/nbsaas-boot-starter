package com.nbsaas.boot.message.data.repository;

import com.nbsaas.boot.message.data.entity.InboxMessage;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface InboxMessageRepository  extends  JpaRepositoryImplementation<InboxMessage, Serializable>{

}