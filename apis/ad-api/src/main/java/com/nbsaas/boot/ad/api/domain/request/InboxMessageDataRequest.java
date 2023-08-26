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
public class InboxMessageDataRequest implements Serializable,RequestId {

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
            //private String sendUserNameName;

        /**
        * 
        **/
            //private String toUserNameName;

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