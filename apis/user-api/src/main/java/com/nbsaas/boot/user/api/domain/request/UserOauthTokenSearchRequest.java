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
public class UserOauthTokenSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    @Search(name = "expires_in", operator = Operator.eq)
    private Long expires_in;

    /**
     *
     **/
    @Search(name = "token_type", operator = Operator.like)
    private String token_type;

    /**
     *
     **/
    @Search(name = "loginSize", operator = Operator.eq)
    private Integer loginSize;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "uid", operator = Operator.like)
    private String uid;

    /**
     *
     **/
    @Search(name = "refresh_token", operator = Operator.like)
    private String refresh_token;

    /**
     *
     **/
    @Search(name = "access_token", operator = Operator.like)
    private String access_token;


}