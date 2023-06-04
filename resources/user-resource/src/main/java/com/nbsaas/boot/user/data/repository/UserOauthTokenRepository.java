package com.nbsaas.boot.user.data.repository;

import com.nbsaas.boot.user.data.entity.UserOauthToken;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface UserOauthTokenRepository extends JpaRepositoryImplementation<UserOauthToken, Serializable> {

}