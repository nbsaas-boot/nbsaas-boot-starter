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
            * 备注
            **/
                private String note;

            /**
            * 
            **/
                private Long creator;

            /**
            * 商户号
            **/
                private String mchId;

            /**
            * 
            **/
                private String payProviderName;

            /**
            * 证书路径
            **/
                private String keyPath;

            /**
            * 服务商Id
            **/
                private String platformId;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 商户Key
            **/
                private String mchKey;

            /**
            * 
            **/
                private PayType payType;

                private String payTypeName;

            /**
            * 费率
            **/
                private BigDecimal rate;

            /**
            * 服务商户号
            **/
                private String platformMchId;

            /**
            * appId
            **/
                private String appId;

            /**
            * 支付名称
            **/
                private String name;

            /**
            * 通知Url
            **/
                private String notifyUrl;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 支付标识
            **/
                private String key;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}