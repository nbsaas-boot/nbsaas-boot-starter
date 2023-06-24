package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class StructureDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     *
     **/
    private Long parent;

    /**
     *
     **/
    //private String parentNameName;

    /**
     * 编码
     **/
    private String code;

    /**
     * 深度
     **/
    private Integer depth;

    /**
     * 名称
     **/
    private String name;

    /**
     * ids
     **/
    private String ids;

    /**
     * 排序号
     **/
    private Integer sortNum;

    /**
     * 主键id
     **/
    private Long id;

    /**
     * 左节点
     **/
    private Integer lft;

    /**
     * 添加时间
     **/
    private Date addDate;

    /**
     * 右节点
     **/
    private Integer rgt;

    /**
     * 最新修改时间
     **/
    private Date lastDate;
}