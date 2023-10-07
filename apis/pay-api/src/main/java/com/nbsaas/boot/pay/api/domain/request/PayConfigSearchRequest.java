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
            * 服务商Id
            **/
            @Search(name = "platformId",operator = Operator.like)
            private String platformId;

            /**
            * 商户Key
            **/
            @Search(name = "mchKey",operator = Operator.like)
            private String mchKey;

            /**
            * 服务商户号
            **/
            @Search(name = "platformMchId",operator = Operator.like)
            private String platformMchId;

            /**
            * appId
            **/
            @Search(name = "appId",operator = Operator.like)
            private String appId;

            /**
            * 通知Url
            **/
            @Search(name = "notifyUrl",operator = Operator.like)
            private String notifyUrl;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}