package com.nbsaas.boot.pay.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.pay.api.domain.enums.SendState;
/**
* 请求对象
*/
@Data
public class CashPaymentDataRequest implements Serializable,RequestId {

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
            private Long tradeAccount;

        /**
        * 微信openId
        **/
            private String openId;

        /**
        * 手续费
        **/
            private BigDecimal fee;

        /**
        * 
        **/
            private SendState sendState;

        /**
        * 提现单号
        **/
            private String cashNo;

        /**
        * 身份证号码
        **/
            private String idNo;

        /**
        * 备注
        **/
            private String demo;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 付款金额
        **/
            private BigDecimal money;

        /**
        * 手机号
        **/
            private String phone;

        /**
        * 业务单号
        **/
            private String bussNo;

        /**
        * 应用id
        **/
            private String appId;

        /**
        * 姓名
        **/
            private String name;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long cashConfig;

        /**
        * 提现金额
        **/
            private BigDecimal cash;

        /**
        * 
        **/
            private Long user;

        /**
        * 
        **/
            //private String cashConfigNameName;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}