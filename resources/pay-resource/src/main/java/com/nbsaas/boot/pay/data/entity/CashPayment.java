package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.pay.api.domain.enums.SendState;
import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@FormAnnotation(title = "付款单")
@Entity
@Table(name = "bs_tenant_pay_cash_payment")
public class CashPayment extends AbstractEntity {


    @SearchItem(label = "提现应用",name = "cashConfig",key = "cashConfig.id",operator = Operator.eq)
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private CashConfig cashConfig;

    @Comment("姓名")
    @SearchItem(label = "姓名",name = "name",key = "name")
    @FormField(title = "姓名", sortNum = "2", grid = true, col = 12)
    @Column(length = 10)
    private String name;

    @Comment("提现单号")
    @SearchItem(label = "提现单号",name = "cashNo",key = "no")
    @FormField(title = "提现单号", sortNum = "1", grid = true, col =12)
    private String cashNo;

    @Comment("付款金额")
    @FormField(title = "付款金额", sortNum = "3", grid = true, col = 12)
    private BigDecimal money;

    @Comment("手续费")
    @FormField(title = "手续费", sortNum = "3", grid = true, col = 12)
    private BigDecimal fee;

    @Comment("身份证号码")
    @Column(length = 20)
    private String idNo;

    @Comment("手机号")
    @Column(length = 20)
    private String phone;

    @Comment("提现金额")
    @FormField(title = "提现金额", sortNum = "3", grid = true, col = 12)
    private BigDecimal cash;

    @Comment("微信openId")
    private String openId;

    @Comment("备注")
    @FormField(title = "备注", sortNum = "5", grid = true, col = 12)
    private String demo;

    private String note;


    @Comment("状态")
    @FormField(title = "状态", sortNum = "4", grid = true, col = 12)
    private SendState sendState;

    @Comment("业务单号")
    private String bussNo;

    @Comment("应用id")
    @Column(length = 50)
    private String appId;

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private TradeAccount tradeAccount;

    @SearchItem(label = "用户", name = "user", key = "user.id", show = false, operator = Operator.eq)
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private PayUser user;
}
