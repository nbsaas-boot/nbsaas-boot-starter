package com.nbsaas.boot.system.api.domain.simple;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class DictItemSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 键值
     **/
    private String dataValue;

    /**
     *
     **/
    private Long dict;

    /**
     * 排序字段
     **/
    private Integer sortNum;

    /**
     *
     **/
    private StoreState storeState;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 编码
     **/
    private String dataCode;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     * 最新修改时间
     **/
    private Date lastDate;


}