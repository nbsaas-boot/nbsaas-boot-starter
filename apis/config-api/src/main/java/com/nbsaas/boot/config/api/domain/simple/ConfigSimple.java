package com.nbsaas.boot.config.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class ConfigSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 配置json数据
     **/
    private String configData;

    /**
     * 配置类标识
     **/
    private String className;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     * 最新修改时间
     **/
    private Date lastDate;


}