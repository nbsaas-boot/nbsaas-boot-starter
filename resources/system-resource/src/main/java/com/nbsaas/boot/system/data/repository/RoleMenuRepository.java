package com.nbsaas.boot.system.data.repository;

import com.nbsaas.boot.system.data.entity.RoleMenu;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.util.List;

public interface RoleMenuRepository extends JpaRepositoryImplementation<RoleMenu, Serializable> {


    List<RoleMenu> findByRoleId(Long roleId);

}