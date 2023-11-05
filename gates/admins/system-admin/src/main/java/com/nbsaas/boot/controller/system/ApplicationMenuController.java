package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.rest.annotations.*;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.apis.ApplicationMenuApi;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationMenuResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.boot.system.ext.apis.ApplicationMenuExtApi;
import com.nbsaas.boot.system.ext.domain.request.MenuDragRequest;
import com.nbsaas.boot.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.boot.system.ext.domain.simple.ApplicationMenuExtSimple;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 对外控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/applicationMenu")
public class ApplicationMenuController {


    @Resource
    private ApplicationMenuApi applicationMenuApi;

    @Resource
    private ApplicationMenuExtApi applicationMenuExtApi;

    @RequestMapping("/tree")
    public ListResponse<ApplicationMenuExtSimple> tree(Long appId, Long userId) {
        return applicationMenuExtApi.tree(appId, userId);
    }

    @RequestMapping("/root")
    public ListResponse<ApplicationMenuExtSimple> root(Long appId) {
        return applicationMenuExtApi.root(appId);
    }

    @RequestMapping("/findByRole")
    public ListResponse<MenuExtSimple> findByRole(Long appId, Long role) {
        return applicationMenuExtApi.findByRole(appId, role);
    }

    @RequestMapping("/selectForPermission")
    public ListResponse<Long> selectForPermission(Long appId, Long role) {
        return applicationMenuExtApi.selectForPermission(appId, role);
    }

    @RequestMapping("/permissions")
    public List<String> permissions(Long appId, Long role) {
        return applicationMenuExtApi.permissions(appId, role);
    }

    @RequestMapping("/selectPermissionByUser")
    public ListResponse<String> selectPermissionByUser(Long appId, Long userId) {
        return applicationMenuExtApi.selectPermissionByUser(appId, userId);
    }


    @RequestMapping("/updateRoleMenus")
    public ResponseObject<?> updateRoleMenus(UpdateRoleMenuRequest request) {
        return applicationMenuExtApi.updateRoleMenus(request);
    }

    @RequestMapping("/drag")
    public ResponseObject<?> drag(MenuDragRequest request) {
        return applicationMenuExtApi.drag(request);
    }




    @RequestMapping("/search")
    public PageResponse<ApplicationMenuSimple> search(ApplicationMenuSearchRequest request) {
        return applicationMenuApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ApplicationMenuSimple> list(ApplicationMenuSearchRequest request) {
        return applicationMenuApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ApplicationMenuResponse> create(@Validated(AddOperator.class) ApplicationMenuDataRequest request) {
        ResponseObject<ApplicationMenuResponse> result = new ResponseObject<>();

        if (request.getApp() == null) {
            result.setCode(501);
            result.setMsg("appId不能为空");
            return result;
        }
        return applicationMenuApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<ApplicationMenuResponse> update(@Validated(UpdateOperator.class) ApplicationMenuDataRequest request) {
        return applicationMenuApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ApplicationMenuDataRequest request) {
        return applicationMenuApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ApplicationMenuResponse> view(@Validated(ViewOperator.class) ApplicationMenuDataRequest request) {
        return applicationMenuApi.view(request);
    }
}