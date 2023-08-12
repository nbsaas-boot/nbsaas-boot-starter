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
public class UserOauthTokenSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 用户unionId
            **/
            @Search(name = "unionId",operator = Operator.like)
            private String unionId;

            /**
            * 用户openId
            **/
            @Search(name = "openId",operator = Operator.like)
            private String openId;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 访问token
            **/
            @Search(name = "accessToken",operator = Operator.like)
            private String accessToken;

            /**
            * token类型
            **/
            @Search(name = "tokenType",operator = Operator.like)
            private String tokenType;

            /**
            * 过期时间
            **/
            @Search(name = "expiresTime",operator = Operator.eq)
            private Long expiresTime;

            /**
            * 刷新token
            **/
            @Search(name = "refreshToken",operator = Operator.like)
            private String refreshToken;

            /**
            * 登录次数
            **/
            @Search(name = "loginSize",operator = Operator.eq)
            private Integer loginSize;



}