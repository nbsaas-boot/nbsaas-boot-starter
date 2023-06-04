package com.nbsaas.boot.system.data.mapper;

import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuSimple> findByUser(@Param("userId") Long userId);
}
