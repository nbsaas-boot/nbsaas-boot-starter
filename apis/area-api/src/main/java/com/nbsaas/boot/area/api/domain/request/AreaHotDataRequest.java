package com.nbsaas.boot.area.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class AreaHotDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 区域id
     **/
    private Long area;

    /**
     * 区域id
     **/
    //private String areaNameName;

    /**
     * 排序号
     **/
    private Integer sortNum;

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