package com.nbsaas.boot.pay.ext.domain.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawalRequest {

    private String name;

    private BigDecimal money;

    private String phone;

    private String openId;

    private String key;

    private String no;

    private Long user;

}
