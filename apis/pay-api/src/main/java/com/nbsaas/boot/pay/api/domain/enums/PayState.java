package com.nbsaas.boot.pay.api.domain.enums;

public enum PayState {
  
  /**
   * 等待支付
   */
  wait,
  
  /**
   * 支付成功
   */
  success,
  
  /**
   * 支付失败
   */
  failure,

  /**
   * 处理中
   */
  handle;

  @Override
  public String toString() {
    if (name().equals("wait")) {
      return "等待支付";
    } else if (name().equals("success")) {
      return "支付成功";
    } else if (name().equals("failure")) {
      return "支付失败";
    }else if (name().equals("handle")) {
      return "支付中";
    } else {
      return super.toString();
    }
  }
}
