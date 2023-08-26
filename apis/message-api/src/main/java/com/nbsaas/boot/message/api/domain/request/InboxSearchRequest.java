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
public class InboxSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
            @Search(name = "dataKey",operator = Operator.like)
            private String dataKey;

            /**
            * 
            **/
            @Search(name = "unReadNum",operator = Operator.eq)
            private Long unReadNum;

            /**
            * 
            **/
            @Search(name = "totalNum",operator = Operator.eq)
            private Long totalNum;

            /**
            * 
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 
            **/
            @Search(name = "icon",operator = Operator.like)
            private String icon;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * 
            **/
            @Search(name = "userId",operator = Operator.eq)
            private Long userId;



}