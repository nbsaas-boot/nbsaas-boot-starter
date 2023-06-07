package com.nbsaas.boot.trade.data.repository;

import com.nbsaas.boot.trade.data.entity.TradeAccountException;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TradeAccountExceptionRepository  extends  JpaRepositoryImplementation<TradeAccountException, Serializable>{

}