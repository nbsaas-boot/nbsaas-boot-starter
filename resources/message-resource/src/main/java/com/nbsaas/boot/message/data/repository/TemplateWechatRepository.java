package com.nbsaas.boot.message.data.repository;

import com.nbsaas.boot.message.data.entity.TemplateWechat;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TemplateWechatRepository  extends  JpaRepositoryImplementation<TemplateWechat, Serializable>{

}