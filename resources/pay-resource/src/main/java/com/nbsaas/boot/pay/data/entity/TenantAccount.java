package com.nbsaas.boot.pay.data.entity;


import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import lombok.Data;

import javax.persistence.*;


@ComposeView
@Data
@FormAnnotation(title = "资金账户管理", model = "资金账户",menu = "1,2,98")
@Entity
@Table(name = "bs_tenant_pay_account")
public class TenantAccount extends AbstractEntity {

  @SearchItem(label = "系统key",name = "key")
  @FormField(title = "系统key", grid = true,required = true)
  @Column(name = "trade_key",length = 50)
  private String key;


  @FormField(title = "资金账号余额", grid = true)
  @SearchItem(label = "资金账号",name = "account",key = "account.id",show = false)
  @FieldConvert
  @ManyToOne(fetch = FetchType.LAZY)
  private TradeAccount account;

}
