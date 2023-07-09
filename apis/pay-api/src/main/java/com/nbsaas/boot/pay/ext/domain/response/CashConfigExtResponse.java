package com.nbsaas.boot.pay.ext.domain.response;

import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CashConfigExtResponse extends CashConfigResponse {

    private BigDecimal amount;
}
