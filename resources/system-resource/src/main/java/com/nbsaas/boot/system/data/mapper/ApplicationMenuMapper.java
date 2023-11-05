package com.nbsaas.boot.system.data.mapper;

import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import com.nbsaas.boot.system.ext.domain.simple.ApplicationMenuExtSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplicationMenuMapper {

    List<ApplicationMenuSimple> findByUser(@Param("appId")Long appId, @Param("userId") Long userId);

}
