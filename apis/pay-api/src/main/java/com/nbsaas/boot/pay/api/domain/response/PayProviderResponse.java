package com.nbsaas.boot.pay.api.domain.response;

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
public class PayProviderResponse  implements Serializable {
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
            private String creatorName;

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