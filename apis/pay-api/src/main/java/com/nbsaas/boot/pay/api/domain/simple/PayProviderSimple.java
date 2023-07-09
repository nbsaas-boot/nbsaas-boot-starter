package com.nbsaas.boot.pay.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class PayProviderSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
                private String platformMch;

            /**
            * 
            **/
                private String note;

            /**
            * 
            **/
                private Long creator;

            /**
            * 
            **/
                private String keyPath;

            /**
            * 
            **/
                private String name;

            /**
            * 
            **/
                private String creatorName;

            /**
            * 
            **/
                private String platformId;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 
            **/
                private String key;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}