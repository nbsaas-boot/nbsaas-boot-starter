package com.nbsaas.boot.pay.ext.domain.request;

import lombok.Data;

@Data
public class PayBack  {
  
  private String no;
  
  
  private String orderNo;
  
  private String payType;
  
  private String userToken;

  private String subAppId;

  private String configKey;
  
}
