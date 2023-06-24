package com.nbsaas.boot.trade.data.repository;

import com.nbsaas.boot.trade.data.entity.BasicTradeAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface BasicTradeAccountRepository extends JpaRepositoryImplementation<BasicTradeAccount, Serializable> {

}