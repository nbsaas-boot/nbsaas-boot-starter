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



	/** 订单编号 */
	@FormField(title = "订单编号", sortNum = "2", grid = true, col =12)
	private String sn;

	/** 订单状态 */
	private OrderStatus orderStatus;

	/** 支付状态 */
	private PaymentStatus paymentStatus;

	/** 配送状态 */
	private ShippingStatus shippingStatus;

	/** 支付手续费 */
	private BigDecimal fee;

	/** 运费 */
	private BigDecimal freight;

	/** 促销折扣 */
	private BigDecimal promotionDiscount;

	/** 优惠券折扣 */
	private BigDecimal couponDiscount;

	/** 调整金额 */
	private BigDecimal offsetAmount;

	/** 已付金额 */
	private BigDecimal amountPaid;

	/**
	 * 订单价格
	 */
	private BigDecimal money;

	/** 赠送积分 */
	private Long point;

	/** 税金 */
	private BigDecimal tax;

	/** 会员 */
	@ManyToOne(fetch = FetchType.LAZY)
	private PayUser user;



}