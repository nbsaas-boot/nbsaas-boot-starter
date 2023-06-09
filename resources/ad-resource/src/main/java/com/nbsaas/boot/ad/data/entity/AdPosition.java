/*
 *
 *
 *
 */
package com.nbsaas.boot.ad.data.entity;

import com.nbsaas.boot.code.annotation.*;
import com.nbsaas.boot.jpa.data.entity.SortEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity - 广告位
 */

@org.hibernate.annotations.Table(appliesTo = "nbsaas_boot_ad_position",comment = "广告位表")
@ComposeView
@FormAnnotation(title = "广告位管理", model = "广告位", menu = "1,51,52")
@Data
@Entity
@Table(name = "nbsaas_boot_ad_position")
public class AdPosition extends SortEntity {

    /**
     * 名称
     */

    @Comment("广告位标识")
    @FormField(title = "标识", sortNum = "10", grid = true, required = true, col = 22)
    @Column(length = 30, name = "data_key")
    private String key;

    @Comment("广告位名称")
    @SearchItem(label = "广告位",name = "name")
    @FormField(title = "广告位", sortNum = "10", grid = true, required = true, col = 22)
    @Column(nullable = false)
    private String name;
    /**
     * 宽度
     */

    @Comment("宽度")
    @FormField(title = "宽度", sortNum = "20", grid = true, type = InputType.el_input_number, col = 22)
    @Column(nullable = false)
    private Integer width;
    /**
     * 高度
     */

    @Comment("高度")
    @FormField(title = "高度", sortNum = "30", grid = true, type = InputType.el_input_number, col = 22)
    @Column(nullable = false)
    private Integer height;


    /**
     * 描述
     */
    @Comment("备注")
    @FormField(title = "备注", sortNum = "40", grid = true, type = InputType.textarea, width = "1000", col = 22)
    private String note;


    /**
     * 模板
     */
    @Comment("模板")
    @Lob
    @Column(nullable = false)
    private String template;
    /**
     * 广告
     */
    @OneToMany(mappedBy = "adPosition", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("adPosition asc")
    private Set<Ad> ads = new HashSet<>();

    public AdPosition() {
        width = 1;
        height = 1;
        template = "";
    }


}