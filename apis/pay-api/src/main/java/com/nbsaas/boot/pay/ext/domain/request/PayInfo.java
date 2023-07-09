package com.nbsaas.boot.pay.ext.domain.request;

import com.nbsaas.boot.pay.api.domain.enums.PayType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PayInfo implements Serializable {

    private BigDecimal money;

    private String payType;

    private String openid;

    private String body;

    private String ip;

    private String userToken;

    private Long commerce;

    private String subMchId;

    private String subAppId;

    Long tenant;

    private PayType payConfigType;

    private String platformId;

    private String platformMchId;

    private String key;

    private String notifyUrl;


}
