package com.nbsaas.boot.message.api.domain.request;

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
public class InboxMessageSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "inbox.dataKey",operator = Operator.eq)
    private String inboxKey;

    @Search(name = "toUser.id",operator = Operator.eq)
    private Long toUser;

    @Search(name = "sendUser.id",operator = Operator.eq)
    private Long sendUser;

    @Search(name = "state",operator = Operator.eq)
    private Integer state;


            /**
            * 
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 
            **/
            @Search(name = "extData",operator = Operator.like)
            private String extData;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "title",operator = Operator.like)
            private String title;



}