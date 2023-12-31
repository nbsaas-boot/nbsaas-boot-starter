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
public class UserAccessLogSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


    @Search(name = "creator.name",operator = Operator.like)
    private String creatorName;


            /**
            * 消耗时间
            **/
            @Search(name = "consumeTime",operator = Operator.eq)
            private Long consumeTime;

            /**
            * ip地址
            **/
            @Search(name = "ip",operator = Operator.like)
            private String ip;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;

            /**
            * url地址
            **/
            @Search(name = "url",operator = Operator.like)
            private String url;



}