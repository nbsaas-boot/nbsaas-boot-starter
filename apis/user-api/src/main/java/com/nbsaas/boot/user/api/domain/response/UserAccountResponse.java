package com.nbsaas.boot.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.user.api.domain.enums.AccountType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserAccountResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            //枚举
            private AccountType accountType;

            private String accountTypeName;

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