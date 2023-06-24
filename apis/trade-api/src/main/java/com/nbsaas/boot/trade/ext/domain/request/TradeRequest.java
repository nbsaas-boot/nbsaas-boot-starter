package com.nbsaas.boot.trade.ext.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class TradeRequest implements Serializable {

    private Long from;

    private Long to;

    private Integer changeType;

    private BigDecimal amount;

    private String note;

}
