package com.nbsaas.boot.pay.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.pay.api.domain.enums.FeeType;
/**
* 请求对象
*/
@Data
public class CashConfigDataRequest implements Serializable,RequestId {

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
            private FeeType feeType;

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