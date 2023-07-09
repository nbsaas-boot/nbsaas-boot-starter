package com.nbsaas.boot.pay.ext.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RefundRequest implements Serializable {


    /**
     * 微信订单号.
     */
    private String transactionId;

    /**
     * 商户订单号.
     */
    private String outTradeNo;

    /**
     * 商户退款单号.
     */
    private String outRefundNo;

    /**
     * 微信退款单号.
     */
    private String refundId;

    /**
     * 退款金额.
     */
    private Integer refundFee;

    /**
     * 应结退款金额.
     */
    private Integer settlementRefundFee;

    /**
     * 标价金额.
     */
    private Integer totalFee;

    /**
     * 应结订单金额.
     */
    private Integer settlementTotalFee;



    private Integer cashRefundFee;
    private String subAppId;
    private String subMchId;
    private String payType;
    Long tenant;
    private String keyPath;

}
