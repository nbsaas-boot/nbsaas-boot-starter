package com.nbsaas.boot.message.data.repository;

import com.nbsaas.boot.message.data.entity.Inbox;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface InboxRepository  extends  JpaRepositoryImplementation<Inbox, Serializable>{

}