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
public class UserRoleSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


            /**
            * 
            **/
            @Search(name = "alias",operator = Operator.like)
            private String alias;

            /**
            * 
            **/
            @Search(name = "description",operator = Operator.like)
            private String description;

            /**
            * 
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;


}