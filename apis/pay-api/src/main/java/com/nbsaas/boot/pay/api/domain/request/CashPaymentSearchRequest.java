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
public class CashPaymentSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "cashConfig.id",operator = Operator.eq)
    private Long cashConfig;

    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "no",operator = Operator.like)
    private String cashNo;

    @Search(name = "user.id",operator = Operator.eq)
    private Long user;


            /**
            * 
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 
            **/
            @Search(name = "openId",operator = Operator.like)
            private String openId;

            /**
            * 
            **/
            @Search(name = "idNo",operator = Operator.like)
            private String idNo;

            /**
            * 
            **/
            @Search(name = "demo",operator = Operator.like)
            private String demo;

            /**
            * 
            **/
            @Search(name = "phone",operator = Operator.like)
            private String phone;

            /**
            * 
            **/
            @Search(name = "bussNo",operator = Operator.like)
            private String bussNo;

            /**
            * 
            **/
            @Search(name = "appId",operator = Operator.like)
            private String appId;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}