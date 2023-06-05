package com.nbsaas.boot.area.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class AreaHotDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 最新修改时间
        **/
        private Date lastDate;

        /**
        * 区域id
        **/
        private Long area;

        /**
        * 排序号
        **/
        private Integer sortNum;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 区域id
        **/
        private String areaName;

        /**
        * 添加时间
        **/
        private Date addDate;
}