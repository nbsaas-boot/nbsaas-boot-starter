package com.nbsaas.boot.pay.ext.domain.simple;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeiXinPaySimple implements Serializable {
  
  private String appid;
  
  private String partnerid;
  
  private String prepayid;
  
  private String packageInfo;
  
  private String noncestr;
  
  private String timestamp;
  
  private String sign;
  
  private String signType;
  
}
