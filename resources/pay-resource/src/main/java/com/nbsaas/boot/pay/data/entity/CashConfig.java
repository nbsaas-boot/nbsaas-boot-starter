package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.code.annotation.FormField;
import com.nbsaas.boot.code.annotation.InputType;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.pay.api.domain.enums.FeeType;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;


@org.hibernate.annotations.Table(appliesTo = "bs_tenant_pay_cash_config",comment = "提现配置")
@Data
@FormAnnotation(model = "提现配置", title = "提现配置管理",menu = "1,5,36")
@Entity
@Table(name = "bs_tenant_pay_cash_config")
public class CashConfig extends AbstractEntity {


    @Comment("提现标识")
    @SearchItem(label = "提现标识", name = "key", key = "key")
    @FormField(title = "提现标识", sortNum = "1", grid = true, required = true)
    @Column(length = 30, name = "data_key")
    private String key;


    @Comment("配置名称")
    @SearchItem(label = "配置名称",name = "name")
    @FormField(title = "配置名称", sortNum = "1", grid = true, required = true, width = "120")
    @Column(length = 10)
    private String name;

    @Comment("手续费类型")
    @SearchItem(label = "手续费类型",name = "feeType",show = false)
    private FeeType feeType;

    @Comment("appId")
    @SearchItem(label = "appId", name = "appId", key = "appId")
    @FormField(title = "appId", sortNum = "1",width = "150",grid = true, required = true)
    @Column(length = 50)
    private String appId;

    @Comment("商户号")
    @FormField(title = "商户号", sortNum = "1", grid = true, required = true)
    @Column(length = 50)
    private String mchId;

    @Comment("商户Key")
    @FormField(title = "商户Key", sortNum = "1",width = "250",grid = true, required = true)
    @Column(length = 50)
    private String mchKey;

    @Comment("证书路径")
    @FormField(title = "证书路径", sortNum = "1", required = true)
    @Column(length = 50)
    private String keyPath;

    @Comment("手续费")
    @FormField(title = "手续费", sortNum = "1", grid = true)
    private BigDecimal fee;

    @Comment("费率")
    @FormField(title = "费率", sortNum = "1", grid = true)
    private BigDecimal rate;

    @Comment("最小金额")
    @FormField(title = "最小金额", sortNum = "1", grid = true,width = "1000")
    private BigDecimal miniMoney;

    @Comment("备注")
    @FormField(title = "备注", sortNum = "1",type = InputType.textarea)
    private String note;

}
