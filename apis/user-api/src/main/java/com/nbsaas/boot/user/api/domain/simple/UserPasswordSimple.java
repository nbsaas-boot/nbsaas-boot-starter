package com.nbsaas.boot.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.user.api.domain.enums.SecurityType;

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
    private Long user;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

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
    private String salt;

    /**
     *
     **/
    private SecurityType securityType;

    /**
     *
     **/
    private String password;

    /**
     * 添加时间
     **/
    private Date addDate;


}