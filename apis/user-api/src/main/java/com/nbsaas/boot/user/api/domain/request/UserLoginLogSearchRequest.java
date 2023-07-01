package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.*;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.nbsaas.boot.user.api.domain.enums.LoginState;

/**
* 搜索bean
*/
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserLoginLogSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "user.id",operator = Operator.eq)
    private Long userId;

    @Search(name = "state",operator = Operator.eq)
    private LoginState state;

    @Search(name = "user.name",operator = Operator.like)
    private String userName;


            /**
            * 
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 
            **/
            @Search(name = "password",operator = Operator.like)
            private String password;

            /**
            * 
            **/
            @Search(name = "ip",operator = Operator.like)
            private String ip;

            /**
            * 
            **/
            @Search(name = "client",operator = Operator.like)
            private String client;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "account",operator = Operator.like)
            private String account;



}