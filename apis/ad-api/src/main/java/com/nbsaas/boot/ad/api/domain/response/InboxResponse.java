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
public class InboxResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Long inboxTemplate;

        /**
        * 
        **/
            private String dataKey;

        /**
        * 
        **/
            private Long unReadNum;

        /**
        * 
        **/
            private String inboxTemplateName;

        /**
        * 
        **/
            private Long totalNum;

        /**
        * 
        **/
            private String name;

        /**
        * 
        **/
            private String icon;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long userId;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}