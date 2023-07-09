package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_info")
public class PayUser extends AbstractEntity {

    @FieldName(parent = "amount",classType = "BigDecimal")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount tradeAccount;

    private String name;


    public static PayUser fromId(Long member) {
        PayUser result = new PayUser();
        result.setId(member);
        return result;

    }
}
