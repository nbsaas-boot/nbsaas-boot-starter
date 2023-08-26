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
public class InboxMessageResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private Long toUser;

        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private String extData;

        /**
        * 
        **/
            private Long sendUser;

        /**
        * 
        **/
            private String sendUserName;

        /**
        * 
        **/
            private String toUserName;

        /**
        * 
        **/
            private Integer state;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private String title;

        /**
        * 
        **/
            private Long inbox;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}