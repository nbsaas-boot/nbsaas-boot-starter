package com.nbsaas.boot.ad.api.domain.response;

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
public class TemplateWechatResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String code;

        /**
        * 
        **/
            private String name;

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
            private String content;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}