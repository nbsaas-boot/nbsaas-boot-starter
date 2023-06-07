package com.nbsaas.boot.trade.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.jpa.data.entity.User;
import lombok.Data;

import javax.persistence.*;


@Data
@FormAnnotation(title = "资金账户")
@Entity
@Table(name = "sys_trade_user_account")
public class UserTradeAccount extends AbstractEntity {

  @Column(name = "trade_key", length = 50)
  private String key;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  private TradeAccount account;

}
