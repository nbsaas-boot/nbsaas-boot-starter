package com.nbsaas.boot.system.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class MenuDataRequest implements Serializable,RequestId {

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
        private String icon;

        /**
        * 
        **/
        private Long nums;

        /**
        * 
        **/
        private Long parent;

        /**
        * 
        **/
        private String path;

        /**
        * 编码
        **/
        private String code;

        /**
        * 左节点
        **/
        private Integer lft;

        /**
        * 深度
        **/
        private Integer depth;

        /**
        * 
        **/
        private String permission;

        /**
        * 添加时间
        **/
        private Date addDate;

        /**
        * 排序号
        **/
        private Integer sortNum;

        /**
        * 
        **/
        private String router;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 菜单类型
        **/
        private Integer catalog;

        /**
        * 是否租户使用
        **/
        private Integer menuType;

        /**
        * 右节点
        **/
        private Integer rgt;

        /**
        * 名称
        **/
        private String name;

        /**
        * ids
        **/
        private String ids;
}