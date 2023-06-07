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
            private AccountType accountType;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String username;

        /**
        * 
        **/
            private Integer loginSize;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}