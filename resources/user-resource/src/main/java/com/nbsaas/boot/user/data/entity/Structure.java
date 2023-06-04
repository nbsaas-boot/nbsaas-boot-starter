package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.code.annotation.CatalogClass;
import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@CatalogClass
@FormAnnotation(title = "组织架构管理", model = "组织架构", menu = "1,27,88")
@Data
@Entity
@Table(name = "sys_structure")
public class Structure extends CatalogEntity {


    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Structure> children;

}
