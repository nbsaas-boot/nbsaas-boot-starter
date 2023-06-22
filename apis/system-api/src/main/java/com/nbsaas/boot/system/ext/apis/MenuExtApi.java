package com.nbsaas.boot.system.ext.apis;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;

public interface MenuExtApi {

    ListResponse<MenuExtSimple> tree(Long userId,Integer version);

    /**
     * 获取系统的菜单树
     *
     * @return
     */
    ListResponse<MenuExtSimple> root();


    /**
     * 根据角色获取系统菜单
     *
     * @param role
     * @return
     */
    ListResponse<MenuExtSimple> findByRole(Long role);

    /**
     * 获取某个角色的菜单id集合
     *
     * @param role
     * @return
     */
    ListResponse<Long> selectForPermission(Long role);

    /**
     * 获取某个用户的权限
     *
     * @param userId
     * @return
     */
    ListResponse<String> selectPermissionByUser(Long userId);

    /**
     * 更新角色的菜单
     *
     * @param request
     * @return
     */
    ResponseObject<?> updateRoleMenus(UpdateRoleMenuRequest request);
}
