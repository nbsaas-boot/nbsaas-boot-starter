package com.nbsaas.boot.system.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class ApplicationMenuResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 应用
        **/
            private Long app;

        /**
        * 父菜单id
        **/
            private Long parent;

        /**
        * 创建人id
        **/
            private Long creator;

        /**
        * 编码
        **/
            private String code;

        /**
        * 分类
        **/
            private Integer catalog;

        /**
        * 应用
        **/
            private String appName;

        /**
        * 
        **/
            private Long num;

        /**
        * 图标
        **/
            private String icon;

        /**
        * 权限
        **/
            private String permission;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 路径
        **/
            private String path;

        /**
        * 父菜单id
        **/
            private String parentName;

        /**
        * 路由
        **/
            private String router;

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
        * 菜单类型
        **/
            private Integer menuType;

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
        * 右节点
        **/
            private Integer rgt;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}