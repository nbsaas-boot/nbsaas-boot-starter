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
            * 
            **/
            @Search(name = "handle",operator = Operator.like)
            private String handle;

            /**
            * 
            **/
            @Search(name = "bussId",operator = Operator.eq)
            private Long bussId;

            /**
            * 
            **/
            @Search(name = "payNo",operator = Operator.like)
            private String payNo;

            /**
            * 
            **/
            @Search(name = "bank",operator = Operator.like)
            private String bank;

            /**
            * 
            **/
            @Search(name = "bussNo",operator = Operator.like)
            private String bussNo;

            /**
            * 
            **/
            @Search(name = "paymentMethod",operator = Operator.like)
            private String paymentMethod;

            /**
            * 
            **/
            @Search(name = "sn",operator = Operator.like)
            private String sn;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "account",operator = Operator.like)
            private String account;



}