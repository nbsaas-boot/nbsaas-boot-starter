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
        * 服务商户号
        **/
            private String platformMch;

        /**
        * 备注
        **/
            private String note;

        /**
        * 
        **/
            private Long creator;

        /**
        * 证书路径
        **/
            private String keyPath;

        /**
        * 服务商名称
        **/
            private String name;

        /**
        * 
        **/
            //private String creatorNameName;

        /**
        * 服务商Id
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
        * 服务商Key
        **/
            private String key;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}