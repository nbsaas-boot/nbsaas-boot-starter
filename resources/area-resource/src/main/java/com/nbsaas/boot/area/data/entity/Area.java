package com.nbsaas.boot.area.data.entity;
/*
 * 版权声明和许可协议
 *
 * 版权所有 (c) 2023 纽百特®
 * 版权所有，保留所有权利
 *
 * 更多信息，请访问我们的网站：
 *
 *   http://www.newbyte.ltd
 *
 * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 *
 */

import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.Table;

@org.hibernate.annotations.Table(appliesTo = "sys_common_area", comment = "地区")
@Data
@Entity
@Table(name = "sys_common_area")
public class Area extends CatalogEntity {


    @Comment("经度")
    private Double lng;

    @Comment("纬度")
    private Double lat;
}
