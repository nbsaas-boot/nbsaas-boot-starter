package com.nbsaas.boot.pay.ext.domain.response;

import com.nbsaas.boot.pay.ext.domain.simple.WeiXinPaySimple;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderPayResponse implements Serializable {

  private WeiXinPaySimple pay;

  private String no;

  private Long dataId;


}
