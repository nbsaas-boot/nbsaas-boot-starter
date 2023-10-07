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
import org.hibernate.annotations.Comment;

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
	@Comment("编号")
	private String sn;

	@Comment("支付单号")
	private String payNo;


	/** 方式 */
	@Comment("方式")
	private Method method;


	/** 支付方式 */
	@Comment("支付方式")
	private String paymentMethod;

	/** 收款银行 */
	@Comment("收款银行")
	private String bank;

	/** 收款账号 */
	@Comment("收款账号")
	private String account;

	/** 支付手续费 */
	@Comment("支付手续费")
	private BigDecimal fee;

	/** 付款金额 */
	@Comment("付款金额")
	private BigDecimal amount;


	/** 付款日期 */
	@Comment("付款日期")
	private Date paymentDate;

	/** 到期时间 */
	@Comment("到期时间")
	private Date expire;

	/** 会员 */
	@FieldConvert
	@ManyToOne(fetch = FetchType.LAZY)
	private PayUser user;

	@Comment("业务id")
	private Long bussId;

	@Comment("业务处理器")
	private String handle;

	@Comment("业务单号")
	@Column(length = 50)
	private String bussNo;

	@Comment("支付状态 0等待支付  1支付成功  2支付失败  3处理中")
	private PayState payState;

	@Comment("配置id")
	@JoinColumn(name = "pay_config_id")
	@FieldName
	@FieldConvert
	@ManyToOne(fetch = FetchType.LAZY)
	private PayConfig payConfig;

}