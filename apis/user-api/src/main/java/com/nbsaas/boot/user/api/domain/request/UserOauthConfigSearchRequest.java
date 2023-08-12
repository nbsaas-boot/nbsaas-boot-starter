package com.nbsaas.boot.user.api.domain.request;

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
public class UserOauthConfigSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 第三方登陆名称
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 第三方登陆标识
            **/
            @Search(name = "model",operator = Operator.like)
            private String model;

            /**
            * 程序key
            **/
            @Search(name = "appKey",operator = Operator.like)
            private String appKey;

            /**
            * 程序密钥
            **/
            @Search(name = "appSecret",operator = Operator.like)
            private String appSecret;

            /**
            * java实现类
            **/
            @Search(name = "className",operator = Operator.like)
            private String className;

            /**
            * 启用状态  1启用 2未启用
            **/
            @Search(name = "state",operator = Operator.eq)
            private Integer state;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}