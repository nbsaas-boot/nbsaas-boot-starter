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
public class UserInfoSearchRequest   extends PageRequest implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 用户介绍
            **/
            @Search(name = "note",operator = Operator.like)
            private String note;

            /**
            * 用户类型
            **/
            @Search(name = "catalog",operator = Operator.eq)
            private Integer catalog;

            /**
            * 用户头像
            **/
            @Search(name = "avatar",operator = Operator.like)
            private String avatar;

            /**
            * 用户登录次数
            **/
            @Search(name = "loginSize",operator = Operator.eq)
            private Integer loginSize;

            /**
            * 手机号码
            **/
            @Search(name = "phone",operator = Operator.like)
            private String phone;

            /**
            * 账号
            **/
            @Search(name = "accountNo",operator = Operator.like)
            private String accountNo;

            /**
            * 用户真实姓名
            **/
            @Search(name = "name",operator = Operator.like)
            private String name;

            /**
            * 主键id
            **/
            @Search(name = "id",operator = Operator.eq)
            private Long id;



}