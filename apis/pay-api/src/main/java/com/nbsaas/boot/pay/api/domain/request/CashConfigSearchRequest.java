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
public class CashConfigSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "key",operator = Operator.like)
    private String key;

    @Search(name = "name",operator = Operator.like)
    private String name;

    @Search(name = "feeType",operator = Operator.like)
    private String feeType;

    @Search(name = "appId",operator = Operator.like)
    private String appId;


            /**
            * 备注
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 商户号
            **/
            @Search(name = "mchId",operator = Operator.like)
            private String mchId;

            /**
            * 证书路径
            **/
            @Search(name = "keyPath",operator = Operator.like)
            private String keyPath;

            /**
            * 商户Key
            **/
            @Search(name = "mchKey",operator = Operator.like)
            private String mchKey;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}