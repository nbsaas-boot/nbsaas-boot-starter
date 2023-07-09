package com.nbsaas.boot.pay.ext.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class OrderPayRequest {

    private Long dataId;

    private BigDecimal money;

    private String payType;

    @NotEmpty(message = "充值配置不能为空")
    private String key;

    @NotEmpty(message = "openId不能为空")
    private String openId;

    private String afterCommand;

    private Long user;

    private String payHandler;


}
