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
public class PayConfigSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "key",operator = Operator.like)
    private String key;

    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "payType",operator = Operator.like)
    private String payType;


            /**
            * 
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 
            **/
            @Search(name = "mchId",operator = Operator.like)
            private String mchId;

            /**
            * 
            **/
            @Search(name = "keyPath",operator = Operator.like)
            private String keyPath;

            /**
            * 
            **/
            @Search(name = "platformId",operator = Operator.like)
            private String platformId;

            /**
            * 
            **/
            @Search(name = "mchKey",operator = Operator.like)
            private String mchKey;

            /**
            * 
            **/
            @Search(name = "platformMchId",operator = Operator.like)
            private String platformMchId;

            /**
            * 
            **/
            @Search(name = "appId",operator = Operator.like)
            private String appId;

            /**
            * 
            **/
            @Search(name = "notifyUrl",operator = Operator.like)
            private String notifyUrl;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}