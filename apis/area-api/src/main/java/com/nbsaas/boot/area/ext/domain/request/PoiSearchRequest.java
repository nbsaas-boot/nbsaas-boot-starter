package com.nbsaas.boot.area.ext.domain.request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class PoiSearchRequest {


  @NotEmpty(message = "地址不能为空")
  private String address;

}
