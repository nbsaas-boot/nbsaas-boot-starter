package com.nbsaas.boot.pay.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class PayProviderDataRequest implements Serializable,RequestId {

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
            //private String creatorNameName;

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