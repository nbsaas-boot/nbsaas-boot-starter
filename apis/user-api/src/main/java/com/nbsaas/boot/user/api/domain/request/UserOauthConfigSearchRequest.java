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
public class UserOauthConfigSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    @Search(name = "state", operator = Operator.eq)
    private Integer state;

    /**
     *
     **/
    @Search(name = "name", operator = Operator.like)
    private String name;

    /**
     *
     **/
    @Search(name = "className", operator = Operator.like)
    private String className;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "model", operator = Operator.like)
    private String model;

    /**
     *
     **/
    @Search(name = "appSecret", operator = Operator.like)
    private String appSecret;

    /**
     *
     **/
    @Search(name = "appKey", operator = Operator.like)
    private String appKey;


}