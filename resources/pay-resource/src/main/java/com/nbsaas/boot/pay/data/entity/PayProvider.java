package com.nbsaas.boot.pay.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;


@org.hibernate.annotations.Table(appliesTo = "config_pay_provider",comment = "支付服务商")
@CreateByUser
@ComposeView
@Data
@FormAnnotation(model = "支付服务商", title = "支付服务商管理",menu = "1,5,36")
@Entity
@Table(name = "config_pay_provider")
public class PayProvider extends AbstractEntity {


    @Comment("服务商名称")
    @SearchItem(label = "服务商名称",name = "name")
    @FormField(title = "服务商名称", grid = true, required = true, width = "120",col = 22)
    @Column(length = 20)
    private String name;


    @Comment("服务商Id")
    @FormField(title = "服务商Id",width = "150",grid = true, required = true,col = 22)
    @Column(length = 50)
    private String platformId;


    @Comment("服务商户号")
    @FormField(title = "服务商户号", grid = true, required = true,col = 22)
    @Column(length = 50)
    private String platformMch;

    @Comment("服务商Key")
    @FormField(title = "服务商Key", grid = true, required = true,col = 22)
    @Column(length = 50, name = "data_key")
    private String key;

    @Comment("证书路径")
    @FormField(title = "证书路径", required = true)
    @Column()
    private String keyPath;


    @Comment("备注")
    @FormField(title = "备注",type = InputType.textarea,col = 22)
    private String note;


    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private PayUser creator;
}
