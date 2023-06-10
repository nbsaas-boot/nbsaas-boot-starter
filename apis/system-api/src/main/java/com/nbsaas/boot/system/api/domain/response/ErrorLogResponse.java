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
public class ErrorLogResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String app;

        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private String param;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private String serverName;

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
            private String url;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}