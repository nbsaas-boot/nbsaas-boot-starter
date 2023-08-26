package com.nbsaas.boot.ad.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class InboxTemplateSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 标识
            **/
                private String dataKey;

            /**
            * 收件箱名称
            **/
                private String name;

            /**
            * 收件箱icon
            **/
                private String icon;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}