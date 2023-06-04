package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class UserRoleCatalogDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 最新修改时间
        **/
        private Date lastDate;

        /**
        * 排序号
        **/
        private Integer sortNum;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 编码
        **/
        private String code;

        /**
        * 左节点
        **/
        private Integer lft;

        /**
        * 右节点
        **/
        private Integer rgt;

        /**
        * 深度
        **/
        private Integer depth;

        /**
        * 名称
        **/
        private String name;

        /**
        * 
        **/
        private String parentName;

        /**
        * ids
        **/
        private String ids;

        /**
        * 添加时间
        **/
        private Date addDate;
}