package com.nbsaas.boot.system.ext.apis;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.ext.domain.request.MenuDragRequest;
import com.nbsaas.boot.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.boot.system.ext.domain.simple.ApplicationMenuExtSimple;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;

import java.util.List;

public interface ApplicationMenuExtApi {


    ListResponse<ApplicationMenuExtSimple> tree(Long appId,Long userId);

    /**
     * 获取系统的菜单树
     *
     * @return
     */
    ListResponse<ApplicationMenuExtSimple> root(Long appId);


    /**
     * 根据角色获取系统菜单
     *
     * @param role
     * @return
     */
    ListResponse<MenuExtSimple> findByRole(Long appId,Long role);

    /**
     * 获取某个角色的菜单id集合
     *
     * @param role
     * @return
     */
    ListResponse<Long> selectForPermission(Long appId,Long role);


    /**
     * 获取这个角色的权限集合
     *
     * @param role
     * @return
     */
    List<String> permissions(Long appId,Long role);

    /**
     * 获取某个用户的权限
     *
     * @param userId
     * @return
     */
    ListResponse<String> selectPermissionByUser(Long appId,Long userId);

    /**
     * 更新角色的菜单
     *
     * @param request
     * @return
     */
    ResponseObject<?> updateRoleMenus(UpdateRoleMenuRequest request);

    /**
     * 菜单拖动
     *
     * @param request
     * @return
     */
    ResponseObject<?> drag(MenuDragRequest request);
}
