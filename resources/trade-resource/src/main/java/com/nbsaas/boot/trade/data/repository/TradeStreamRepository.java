package com.nbsaas.boot.trade.data.repository;

import com.nbsaas.boot.trade.data.entity.TradeStream;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;

public interface TradeStreamRepository  extends  JpaRepositoryImplementation<TradeStream, Serializable>{

}