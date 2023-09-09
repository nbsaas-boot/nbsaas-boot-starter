package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.DataScope;
import com.nbsaas.boot.rest.enums.State;
import com.nbsaas.boot.rest.filter.Operator;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ada on 2017/7/21.
 */

@Data
@MappedSuperclass
public abstract class AbstractUser extends AbstractEntity {


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "user_info_attribute", joinColumns = {@JoinColumn(name = "user_id")})
    @MapKeyColumn(name = "name", length = 36)
    @Column(name = "attr", length = 100)
    private Map<String, String> attributes = new HashMap<String, String>();

    @Comment("用户头像")
    private String avatar;

    @Comment("用户类型")
    private Integer catalog;


    @Comment("手机号码")
    @Column(length = 15)
    private String phone;

    @Comment("用户登录次数")
    private Integer loginSize = 0;

    @Comment("用户真实姓名")
    @Column(length = 20)
    private String name;

    @SearchItem(label = "所在组织", name = "structure", key = "structure.id", classType = Long.class, operator = Operator.eq)
    @Comment("所在组织")
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure structure;

    @Comment("数据范围")
    @FormField(title = "数据范围", sortNum = "1", type = InputType.el_radio_group, grid = true)
    private DataScope dataScope;

    @Comment("用户介绍")
    @Column(length = 100)
    private String note;

    @Comment("用户状态")
    @Enumerated()
    private State state;

}
