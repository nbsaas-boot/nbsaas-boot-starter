package com.nbsaas.boot.message.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class InboxSimple implements Serializable {

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