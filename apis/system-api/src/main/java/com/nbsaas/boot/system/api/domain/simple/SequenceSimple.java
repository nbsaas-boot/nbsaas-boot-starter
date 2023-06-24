package com.nbsaas.boot.system.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class SequenceSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Date updateDate;

    /**
     *
     **/
    private String name;

    /**
     *
     **/
    private Integer increment;

    /**
     *
     **/
    private Long currentNum;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     *
     **/
    private Date createDate;

    /**
     * 最新修改时间
     **/
    private Date lastDate;


}