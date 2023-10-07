/*
 * 
 * 
 * 
 */
package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.pay.api.domain.enums.OrderStatus;
import com.nbsaas.boot.pay.api.domain.enums.PaymentStatus;
import com.nbsaas.boot.pay.api.domain.enums.ShippingStatus;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Entity - 订单
 * 
 * 
 * 
 */
@Data
@Entity
@Table(name = "bs_tenant_pay_order")
public class PayOrder extends AbstractEntity {


	@Comment("订单编号")
	/** 订单编号 */
	@FormField(title = "订单编号", sortNum = "2", grid = true, col =12)
	private String sn;

	@Comment("订单状态")
	/** 订单状态 */
	private OrderStatus orderStatus;

	@Comment("支付状态")
	/** 支付状态 */
	private PaymentStatus paymentStatus;

	@Comment("配送状态")
	/** 配送状态 */
	private ShippingStatus shippingStatus;

	@Comment("支付手续费")
	/** 支付手续费 */
	private BigDecimal fee;

	@Comment("运费")
	/** 运费 */
	private BigDecimal freight;

	@Comment("促销折扣")
	/** 促销折扣 */
	private BigDecimal promotionDiscount;

	@Comment("优惠券折扣")
	/** 优惠券折扣 */
	private BigDecimal couponDiscount;


	@Comment("调整金额")
	/** 调整金额 */
	private BigDecimal offsetAmount;

	@Comment("已付金额")
	/** 已付金额 */
	private BigDecimal amountPaid;


	@Comment("订单价格")
	/**
	 * 订单价格
	 */
	private BigDecimal money;

	@Comment("赠送积分")
	/** 赠送积分 */
	private Long point;

	@Comment("税金")
	/** 税金 */
	private BigDecimal tax;

	@Comment("会员")
	/** 会员 */
	@ManyToOne(fetch = FetchType.LAZY)
	private PayUser user;



}