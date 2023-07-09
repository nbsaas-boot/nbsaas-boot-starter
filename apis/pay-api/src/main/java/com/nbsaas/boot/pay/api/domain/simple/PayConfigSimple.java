package com.nbsaas.boot.pay.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.pay.api.domain.enums.PayType;

/**
* 列表对象
*/
@Data
public class PayConfigSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
                private Long payProvider;

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
                private String mchId;

            /**
            * 
            **/
                private String payProviderName;

            /**
            * 
            **/
                private String keyPath;

            /**
            * 
            **/
                private String platformId;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 
            **/
                private String mchKey;

            /**
            * 
            **/
                private PayType payType;

                private String payTypeName;

            /**
            * 
            **/
                private BigDecimal rate;

            /**
            * 
            **/
                private String platformMchId;

            /**
            * 
            **/
                private String appId;

            /**
            * 
            **/
                private String name;

            /**
            * 
            **/
                private String notifyUrl;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 
            **/
                private String key;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}