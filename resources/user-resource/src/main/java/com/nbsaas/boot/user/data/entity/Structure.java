package com.nbsaas.boot.user.data.entity;

import com.nbsaas.boot.code.annotation.CatalogClass;
import com.nbsaas.boot.code.annotation.FieldConvert;
import com.nbsaas.boot.code.annotation.FieldName;
import com.nbsaas.boot.code.annotation.FormAnnotation;
import com.nbsaas.boot.jpa.data.entity.CatalogEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@org.hibernate.annotations.Table(appliesTo = "sys_structure",comment = "组织架构")
@CatalogClass
@FormAnnotation(title = "组织架构管理", model = "组织架构", menu = "1,27,88")
@Data
@Entity
@Table(name = "sys_structure")
public class Structure extends CatalogEntity {


    //@JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @FieldName
    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private Structure parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Structure> children;

    @Override
    public Serializable getParentId() {
        if (parent != null) {
            return parent.getId();
        }
        return null;
    }
}
