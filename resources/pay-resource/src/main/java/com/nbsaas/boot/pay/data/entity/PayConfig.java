package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.pay.api.domain.enums.PayType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@CreateByUser
@ComposeView
@Data
@FormAnnotation(model = "支付配置", title = "支付配置管理",menu = "1,5,36")
@Entity
@Table(name = "bs_tenant_pay_online_config")
public class PayConfig extends AbstractEntity {

    @SearchItem(label = "支付标识", name = "key", key = "key")
    @FormField(title = "支付标识", grid = true, required = true)
    @Column(length = 30, name = "data_key")
    private String key;


    @SearchItem(label = "支付名称",name = "name")
    @FormField(title = "支付名称", grid = true, required = true, width = "120")
    @Column(length = 10)
    private String name;


    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private PayUser creator;

    @FormField(title = "支付模式",grid = true, required = true)
    @SearchItem(label = "支付模式",name = "payType")
    private PayType payType;

    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private PayProvider payProvider;

    @FormField(title = "服务商Id",width = "150",grid = true, required = true)
    @Column(length = 50)
    private String platformId;

    @FormField(title = "服务商户号", grid = true, required = true)
    @Column(length = 50)
    private String platformMchId;


    @FormField(title = "appId",width = "150",grid = true, required = true)
    @Column(length = 50)
    private String appId;



    @FormField(title = "商户号", grid = true, required = true)
    @Column(length = 50)
    private String mchId;

    @FormField(title = "商户Key",width = "250",grid = true, required = true)
    @Column(length = 50)
    private String mchKey;

    @FormField(title = "证书路径", required = true)
    @Column()
    private String keyPath;

    @FormField(title = "通知Url", required = true)
    @Column()
    private String notifyUrl;

    @FormField(title = "费率", grid = true)
    private BigDecimal rate;


    @FormField(title = "备注",type = InputType.textarea)
    private String note;

}
