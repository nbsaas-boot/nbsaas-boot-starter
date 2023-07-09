package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.pay.api.domain.enums.SendState;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@FormAnnotation(title = "付款单")
@Entity
@Table(name = "bs_tenant_pay_cash_payment")
public class CashPayment extends AbstractEntity {


    @SearchItem(label = "提现应用",name = "cashConfig",key = "cashConfig.id",operator = "eq")
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private CashConfig cashConfig;

    @SearchItem(label = "姓名",name = "name",key = "name")
    @FormField(title = "姓名", sortNum = "2", grid = true, col = 12)
    @Column(length = 10)
    private String name;

    @SearchItem(label = "提现单号",name = "cashNo",key = "no")
    @FormField(title = "提现单号", sortNum = "1", grid = true, col =12)
    private String cashNo;


    @FormField(title = "付款金额", sortNum = "3", grid = true, col = 12)
    private BigDecimal money;


    @FormField(title = "手续费", sortNum = "3", grid = true, col = 12)
    private BigDecimal fee;

    @Column(length = 20)
    private String idNo;

    @Column(length = 20)
    private String phone;


    @FormField(title = "提现金额", sortNum = "3", grid = true, col = 12)
    private BigDecimal cash;

    private String openId;

    @FormField(title = "备注", sortNum = "5", grid = true, col = 12)
    private String demo;

    private String note;

    @FormField(title = "状态", sortNum = "4", grid = true, col = 12)
    private SendState sendState;

    private String bussNo;

    @Column(length = 50)
    private String appId;

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount tradeAccount;

    @SearchItem(label = "用户", name = "user", key = "user.id", show = false, operator = "eq")
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private PayUser user;
}
