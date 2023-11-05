package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.RoleApplicationMenu;
import com.nbsaas.boot.system.data.entity.RoleMenu;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import java.io.Serializable;
import java.util.List;

public interface RoleApplicationMenuRepository  extends  JpaRepositoryImplementation<RoleApplicationMenu, Serializable>{

    List<RoleApplicationMenu> findByRoleId(Long roleId);

}