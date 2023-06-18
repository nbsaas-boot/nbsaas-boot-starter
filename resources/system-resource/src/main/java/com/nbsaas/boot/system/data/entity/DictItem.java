package com.nbsaas.boot.system.data.entity;


import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.SearchBean;
import com.nbsaas.boot.code.annotation.SearchItem;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SearchBean(items = {
        @SearchItem(name = "dictKey", key = "dict.dictKey", label = "key搜索", show = false, operator = "eq")
})
@org.hibernate.annotations.Table(appliesTo = "sys_dict_item", comment = "字典子项")
@Data
@Entity
@Table(name = "sys_dict_item")
public class DictItem extends AbstractEntity {


    @Comment("编码")
    private String dataCode;

    @Comment("键值")
    private String dataValue;

    @Comment("排序字段")
    private Integer sortNum;

    private StoreState storeState;

    @SearchItem(name = "dict", key = "dict.id", label = "字典搜索", show = false, operator = "eq")
    @ManyToOne(fetch = FetchType.LAZY)
    @FieldConvert
    @FieldName(parent = "title")
    private Dict dict;

}
