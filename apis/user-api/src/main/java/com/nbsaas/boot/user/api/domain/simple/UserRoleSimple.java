package com.nbsaas.boot.user.api.domain.simple;

import com.nbsaas.boot.user.api.domain.enums.RoleType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserRoleSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     *
     **/
    private String alias;

    /**
     *
     **/
    private String description;

    /**
     *
     **/
    private String catalogName;

    /**
     *
     **/
    private Long catalog;

    /**
     *
     **/
    private String name;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private RoleType type;

    /**
     * 添加时间
     **/
    private Date addDate;


}