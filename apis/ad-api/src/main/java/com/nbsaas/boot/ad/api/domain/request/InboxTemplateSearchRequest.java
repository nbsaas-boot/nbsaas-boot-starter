package com.nbsaas.boot.ad.api.domain.request;

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
public class InboxTemplateSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 标识
            **/
            @Search(name = "dataKey",operator = Operator.like)
            private String dataKey;

            /**
            * 收件箱名称
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 收件箱icon
            **/
            @Search(name = "icon",operator = Operator.like)
            private String icon;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}