package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 搜索bean
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserOauthTokenSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    @Search(name = "unionId", operator = Operator.like)
    private String unionId;

    /**
     *
     **/
    @Search(name = "openId", operator = Operator.like)
    private String openId;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "accessToken", operator = Operator.like)
    private String accessToken;

    /**
     *
     **/
    @Search(name = "tokenType", operator = Operator.like)
    private String tokenType;

    /**
     *
     **/
    @Search(name = "expiresTime", operator = Operator.eq)
    private Long expiresTime;

    /**
     *
     **/
    @Search(name = "refreshToken", operator = Operator.like)
    private String refreshToken;

    /**
     *
     **/
    @Search(name = "loginSize", operator = Operator.eq)
    private Integer loginSize;


}