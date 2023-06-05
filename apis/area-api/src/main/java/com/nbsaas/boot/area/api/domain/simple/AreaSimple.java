package com.nbsaas.boot.area.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class AreaSimple implements Serializable {

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
            * 经度
            **/
            private Double lng;

            /**
            * 纬度
            **/
            private Double lat;

            /**
            * ids
            **/
            private String ids;

            /**
            * 添加时间
            **/
            private Date addDate;


    }