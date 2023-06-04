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
public class UserLoginLogSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "client", operator = Operator.like)
    private String client;

    /**
     *
     **/
    @Search(name = "note", operator = Operator.like)
    private String note;

    /**
     *
     **/
    @Search(name = "account", operator = Operator.like)
    private String account;

    /**
     *
     **/
    @Search(name = "ip", operator = Operator.like)
    private String ip;

    /**
     *
     **/
    @Search(name = "password", operator = Operator.like)
    private String password;


}