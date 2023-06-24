package com.nbsaas.boot.trade.api.domain.request;

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
public class TradeAccountExceptionSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    @Search(name = "account.id", operator = Operator.like)
    private Long account;


    /**
     *
     **/
    @Search(name = "checkValue", operator = Operator.like)
    private String checkValue;

    /**
     *
     **/
    @Search(name = "oldSalt", operator = Operator.like)
    private String oldSalt;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;

    /**
     *
     **/
    @Search(name = "oldCheckValue", operator = Operator.like)
    private String oldCheckValue;


}