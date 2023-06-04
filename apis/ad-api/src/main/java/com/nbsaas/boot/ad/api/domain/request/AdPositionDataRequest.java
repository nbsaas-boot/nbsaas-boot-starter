package com.nbsaas.boot.ad.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class AdPositionDataRequest implements Serializable,RequestId {

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
        * 
        **/
        private String name;

        /**
        * 
        **/
        private String key;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 
        **/
        private Integer height;

        /**
        * 
        **/
        private String note;

        /**
        * 
        **/
        private Integer width;

        /**
        * 
        **/
        private String template;

        /**
        * 添加时间
        **/
        private Date addDate;
}