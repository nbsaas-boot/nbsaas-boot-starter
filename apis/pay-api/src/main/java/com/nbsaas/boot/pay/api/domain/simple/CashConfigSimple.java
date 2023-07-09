package com.nbsaas.boot.pay.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.pay.api.domain.enums.FeeType;

/**
* 列表对象
*/
@Data
public class CashConfigSimple implements Serializable {

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