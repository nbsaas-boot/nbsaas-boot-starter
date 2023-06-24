package com.nbsaas.boot.user.api.domain.simple;

import com.nbsaas.boot.user.api.domain.enums.SecurityType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserPasswordSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private String password;

    /**
     *
     **/
    private String salt;

    /**
     *
     **/
    private SecurityType securityType;

    private String securityTypeName;

    /**
     *
     **/
    private Integer checkSize;

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
     * 最新修改时间
     **/
    private Date lastDate;


}