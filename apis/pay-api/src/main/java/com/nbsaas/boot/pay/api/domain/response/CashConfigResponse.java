package com.nbsaas.boot.pay.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.pay.api.domain.enums.FeeType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class CashConfigResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String note;

        /**
        * 
        **/
            private String mchId;

        /**
        * 
        **/
            private BigDecimal miniMoney;

        /**
        * 
        **/
            private String keyPath;

        /**
        * 
        **/
            private BigDecimal fee;

        /**
        * 
        **/
            //枚举
            private FeeType feeType;

            private String feeTypeName;

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
            private BigDecimal rate;

        /**
        * 
        **/
            private String appId;

        /**
        * 
        **/
            private String name;

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