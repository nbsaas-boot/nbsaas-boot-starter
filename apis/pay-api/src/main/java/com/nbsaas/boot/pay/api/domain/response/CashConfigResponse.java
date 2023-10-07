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
        * 备注
        **/
            private String note;

        /**
        * 商户号
        **/
            private String mchId;

        /**
        * 最小金额
        **/
            private BigDecimal miniMoney;

        /**
        * 证书路径
        **/
            private String keyPath;

        /**
        * 手续费
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
        * 商户Key
        **/
            private String mchKey;

        /**
        * 费率
        **/
            private BigDecimal rate;

        /**
        * appId
        **/
            private String appId;

        /**
        * 配置名称
        **/
            private String name;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 提现标识
        **/
            private String key;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}