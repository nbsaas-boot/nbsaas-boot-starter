package com.nbsaas.boot.pay.ext.domain.response;


import com.nbsaas.boot.pay.api.domain.request.CashConfigSearchRequest;
import lombok.Data;

@Data
public class CashConfigExtSearchRequest extends CashConfigSearchRequest {

    private Long user;
}
