package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.user.api.domain.enums.AccountType;
/**
* 请求对象
*/
@Data
public class UserAccountDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            private AccountType accountType;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 用户id
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 用户名
        **/
            private String username;

        /**
        * 登陆次数
        **/
            private Integer loginSize;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}