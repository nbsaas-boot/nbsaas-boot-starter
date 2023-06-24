package com.nbsaas.boot.user.api.domain.response;

import com.nbsaas.boot.user.api.domain.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserAccountResponse implements Serializable {
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