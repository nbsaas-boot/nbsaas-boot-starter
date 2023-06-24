package com.nbsaas.boot.trade.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.trade.api.domain.enums.AccountType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@Data
@FormAnnotation(model = "资金账户", title = "资金账户管理", menu = "")
@Entity
@Table(name = "sys_trade_account")
public class TradeAccount extends AbstractEntity {


    @FormField(title = "账号名称", sortNum = "2", grid = true, col = 12)
    @Column(length = 20)
    private String name;


    /**
     * 总金额
     */
    @FormField(title = "总金额", sortNum = "2", grid = true, col = 12)
    private BigDecimal amount;


    /**
     * 账号类型
     */
    @FormField(title = "账号类型", sortNum = "2", grid = true)
    private AccountType accountType;

    /**
     * 盐
     */
    @Column(length = 32)
    @FormField(title = "校验盐", sortNum = "2", grid = true)
    private String salt;

    /**
     * 校验值
     */
    @Column(length = 50)
    @FormField(title = "校验值", sortNum = "2", grid = true)
    private String checkValue;

    @FormField(title = "当前流水号", sortNum = "2", grid = true)
    private Integer serialNo;

}
