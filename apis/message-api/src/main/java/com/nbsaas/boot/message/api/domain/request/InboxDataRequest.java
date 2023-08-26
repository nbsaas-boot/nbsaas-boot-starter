package com.nbsaas.boot.message.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class InboxDataRequest implements Serializable,RequestId {

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
            //private String inboxTemplateNameName;

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