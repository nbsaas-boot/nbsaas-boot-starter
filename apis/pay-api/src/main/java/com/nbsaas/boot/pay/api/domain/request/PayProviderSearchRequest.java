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
public class PayProviderSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "name",operator = Operator.like)
    private String name;


            /**
            * 服务商户号
            **/
            @Search(name = "platformMch",operator = Operator.like)
            private String platformMch;

            /**
            * 备注
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 证书路径
            **/
            @Search(name = "keyPath",operator = Operator.like)
            private String keyPath;

            /**
            * 服务商Id
            **/
            @Search(name = "platformId",operator = Operator.like)
            private String platformId;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 服务商Key
            **/
            @Search(name = "key",operator = Operator.like)
            private String key;



}