package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.apis.MenuApi;
import com.nbsaas.boot.system.api.domain.request.MenuDataRequest;
import com.nbsaas.boot.system.api.domain.request.MenuSearchRequest;
import com.nbsaas.boot.system.api.domain.response.MenuResponse;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import com.nbsaas.boot.system.ext.apis.MenuExtApi;
import com.nbsaas.boot.system.ext.domain.request.MenuDragRequest;
import com.nbsaas.boot.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/menu")
public class MenuController {


    @Resource
    private MenuApi menuApi;


    @Resource
    private MenuExtApi menuExtApi;

    @RequiresPermissions("menu")
    @RequestMapping("/drag")
    public ResponseObject<?> drag(MenuDragRequest menuDragRequest) {
        return menuExtApi.drag(menuDragRequest);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/root")
    public ListResponse<MenuExtSimple> root() {
        return menuExtApi.root();
    }

    @RequiresPermissions("menu")
    @RequestMapping("/findByRole")
    public ListResponse<MenuExtSimple> findByRole(Long role) {
        return menuExtApi.findByRole(role);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/selectForPermission")
    public ListResponse<Long> selectForPermission(Long role) {
        return menuExtApi.selectForPermission(role);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/selectPermissionByUser")
    public ListResponse<String> selectPermissionByUser(Long userId) {
        return menuExtApi.selectPermissionByUser(userId);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/updateRoleMenus")
    public ResponseObject<?> updateRoleMenus(@RequestBody @Validated UpdateRoleMenuRequest request) {
        return menuExtApi.updateRoleMenus(request);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/search")
    public PageResponse<MenuSimple> search(MenuSearchRequest request) {
        return menuApi.search(request);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/list")
    public ListResponse<MenuSimple> list(MenuSearchRequest request) {
        return menuApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @RequiresPermissions("menu")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject
            <MenuResponse> create(@Validated(AddOperator.class) MenuDataRequest request) {
        return menuApi.create(request);
    }

    @RequiresPermissions("menu")
    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<MenuResponse> update(@Validated(UpdateOperator.class) MenuDataRequest request) {
        return menuApi.update(request);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) MenuDataRequest request) {
        return menuApi.delete(request);
    }

    @RequiresPermissions("menu")
    @RequestMapping("/view")
    public ResponseObject<MenuResponse> view(@Validated(ViewOperator.class) MenuDataRequest request) {
        return menuApi.view(request);
    }
}