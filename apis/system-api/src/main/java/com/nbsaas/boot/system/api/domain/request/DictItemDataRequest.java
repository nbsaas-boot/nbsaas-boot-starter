package com.nbsaas.boot.system.api.domain.request;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class DictItemDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Long dict;

    /**
     * 最新修改时间
     **/
    private Date lastDate;

    /**
     * 主键id
     **/
    private Long id;

    /**
     *
     **/
    private StoreState storeState;

    /**
     *
     **/
    private String title;

    /**
     * 排序字段
     **/
    private Integer sortNum;

    /**
     * 键值
     **/
    private String dataValue;

    /**
     * 编码
     **/
    private String dataCode;

    /**
     * 添加时间
     **/
    private Date addDate;
}