package com.nbsaas.boot.trade.data.repository;

import com.nbsaas.boot.trade.data.entity.TradeAccount;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TradeAccountRepository  extends  JpaRepositoryImplementation<TradeAccount, Serializable>{

}