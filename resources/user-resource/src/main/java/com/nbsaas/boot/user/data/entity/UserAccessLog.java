package com.nbsaas.boot.user.data.entity;


import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;


@CreateByUser
@Data
@FormAnnotation(title = "访问日志管理", model = "访问日志", menu = "1,79,133")
@Entity
@org.hibernate.annotations.Table(appliesTo = "user_access_log",comment = "访问日志")
@Table(name = "user_access_log")
public class UserAccessLog extends AbstractEntity {

    @Comment("用户")
    @SearchItem(label = "用户昵称", name = "creatorName", key = "creator.name")
    @FormField(title = "用户", grid = true)
    @FieldConvert
    @FieldName
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo creator;

    @Comment("消耗时间")
    private Long consumeTime;

    @Comment("ip地址")
    @FormField(title = "ip地址", grid = true, width = "200", sort = true)
    @Column(length = 20)
    private String ip;

    @Comment("url地址")
    @FormField(title = "url地址", grid = true, width = "1000")
    private String url;

    @Comment("存储地址")
    private StoreState storeState;

}
