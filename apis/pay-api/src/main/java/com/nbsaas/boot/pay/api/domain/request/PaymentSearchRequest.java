package com.nbsaas.boot.pay.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaymentSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 业务处理器
            **/
            @Search(name = "handle",operator = Operator.like)
            private String handle;

            /**
            * 业务id
            **/
            @Search(name = "bussId",operator = Operator.eq)
            private Long bussId;

            /**
            * 支付单号
            **/
            @Search(name = "payNo",operator = Operator.like)
            private String payNo;

            /**
            * 收款银行
            **/
            @Search(name = "bank",operator = Operator.like)
            private String bank;

            /**
            * 业务单号
            **/
            @Search(name = "bussNo",operator = Operator.like)
            private String bussNo;

            /**
            * 支付方式
            **/
            @Search(name = "paymentMethod",operator = Operator.like)
            private String paymentMethod;

            /**
            * 编号
            **/
            @Search(name = "sn",operator = Operator.like)
            private String sn;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 收款账号
            **/
            @Search(name = "account",operator = Operator.like)
            private String account;



}