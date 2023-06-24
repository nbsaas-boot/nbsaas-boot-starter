package com.nbsaas.boot.trade.data.repository;

import com.nbsaas.boot.trade.data.entity.UserTradeAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface UserTradeAccountRepository extends JpaRepositoryImplementation<UserTradeAccount, Serializable> {

}