package com.nbsaas.boot.trade.api.domain.request;

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
public class TradeInfoSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "from.id",operator = Operator.like)
    private Long from;

    @Search(name = "to.id",operator = Operator.like)
    private Long to;


            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}