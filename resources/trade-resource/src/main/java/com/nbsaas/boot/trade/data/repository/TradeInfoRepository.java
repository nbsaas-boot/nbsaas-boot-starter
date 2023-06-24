package com.nbsaas.boot.trade.data.repository;

import com.nbsaas.boot.trade.data.entity.TradeInfo;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;

public interface TradeInfoRepository extends JpaRepositoryImplementation<TradeInfo, Serializable> {

}