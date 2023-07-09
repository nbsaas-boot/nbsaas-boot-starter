/*
 * 
 * 
 * 
 */
package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.pay.api.domain.enums.Method;
import com.nbsaas.boot.pay.api.domain.enums.PayState;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity - 收款单
 * 
 * 
 * 
 */
@Data
@Entity
@Table(name = "bs_tenant_pay_payment")
public class Payment extends AbstractEntity {


	/** 编号 */
	private String sn;

	private String payNo;


	/** 方式 */
	private Method method;


	/** 支付方式 */
	private String paymentMethod;

	/** 收款银行 */
	private String bank;

	/** 收款账号 */
	private String account;

	/** 支付手续费 */
	private BigDecimal fee;

	/** 付款金额 */
	private BigDecimal amount;


	/** 付款日期 */
	private Date paymentDate;

	/** 到期时间 */
	private Date expire;

	/** 会员 */
	@FieldConvert
	@ManyToOne(fetch = FetchType.LAZY)
	private PayUser user;

	private Long bussId;


	private String handle;

	@Column(length = 50)
	private String bussNo;

	private PayState payState;

	@FieldName
	@FieldConvert
	@ManyToOne(fetch = FetchType.LAZY)
	private PayConfig payConfig;

}