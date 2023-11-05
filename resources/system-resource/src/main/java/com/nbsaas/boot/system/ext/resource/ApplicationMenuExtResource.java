package com.nbsaas.boot.system.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.apis.ApplicationMenuApi;
import com.nbsaas.boot.system.api.apis.RoleApi;
import com.nbsaas.boot.system.api.apis.RoleApplicationMenuApi;
import com.nbsaas.boot.system.api.domain.field.RoleMenuField;
import com.nbsaas.boot.system.api.domain.request.RoleApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.response.RoleResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.boot.system.api.domain.simple.RoleApplicationMenuSimple;
import com.nbsaas.boot.system.data.entity.ApplicationMenu;
import com.nbsaas.boot.system.data.entity.RoleApplicationMenu;
import com.nbsaas.boot.system.data.mapper.ApplicationMenuMapper;
import com.nbsaas.boot.system.data.repository.RoleApplicationMenuRepository;
import com.nbsaas.boot.system.ext.apis.ApplicationMenuExtApi;
import com.nbsaas.boot.system.ext.domain.request.MenuDragRequest;
import com.nbsaas.boot.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.boot.system.ext.domain.simple.ApplicationMenuExtSimple;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApplicationMenuExtResource implements ApplicationMenuExtApi {

    @Resource
    private ApplicationMenuApi applicationMenuApi;

    @Resource
    private ApplicationMenuMapper applicationMenuMapper;

    @Resource
    private RoleApplicationMenuApi roleApplicationMenuApi;

    @Resource
    private RoleApplicationMenuRepository roleApplicationMenuRepository;

    @Resource
    private RoleApi roleApi;

    @Transactional(readOnly = true)
    @Override
    public ListResponse<ApplicationMenuExtSimple> tree(Long appId, Long userId) {
        ListResponse<ApplicationMenuExtSimple> result = new ListResponse<>();
        List<ApplicationMenuSimple> list = applicationMenuMapper.findByUser(appId, userId);
        if (list != null) {
            result.setData(makeTree(list));
        }
        return result;
    }


    @Transactional(readOnly = true)
    @Override
    public ListResponse<ApplicationMenuExtSimple> root(Long appId) {
        ListResponse<ApplicationMenuExtSimple> result = new ListResponse<>();
        List<ApplicationMenuSimple> menus = applicationMenuApi.listData(Filter.eq("app.id", appId));
        result.setData(makeTree(menus));
        return result;
    }

    private List<ApplicationMenuExtSimple> makeTree(List<ApplicationMenuSimple> menuList) {
        List<ApplicationMenuExtSimple> tree = new ArrayList<>();
        if (menuList != null && !menuList.isEmpty()) {
            List<ApplicationMenuExtSimple> ls = menuList.stream().map(item -> {
                ApplicationMenuExtSimple simple = new ApplicationMenuExtSimple();
                BeanUtils.copyProperties(item, simple);
                if (simple.getSortNum() == null) {
                    simple.setSortNum(0);
                }
                return simple;
            }).collect(Collectors.toList());
            Map<Long, ApplicationMenuExtSimple> map = new HashMap<>();
            for (ApplicationMenuExtSimple item : ls) {
                map.put(item.getId(), item);
            }
            for (ApplicationMenuExtSimple item : ls) {
                if (item.getParent() == null) {
                    tree.add(item);
                } else {
                    ApplicationMenuExtSimple parent = map.get(item.getParent());
                    if (parent != null) {
                        if (parent.getChildren() == null) {
                            parent.setChildren(new ArrayList<>());
                        }
                        parent.getChildren().add(item);
                    }
                }
            }

        }
        tree.sort(Comparator.comparingLong(ApplicationMenuExtSimple::getSortNum));

        for (ApplicationMenuExtSimple menuExtSimple : tree) {
            if (menuExtSimple.getChildren() != null) {
                menuExtSimple.getChildren().sort(Comparator.comparingLong(ApplicationMenuSimple::getSortNum));
            }
        }

        return tree;
    }

    @Override
    public ListResponse<MenuExtSimple> findByRole(Long appId, Long role) {
        return null;
    }

    @Override
    public ListResponse<Long> selectForPermission(Long appId, Long role) {
        ListResponse<Long> result = new ListResponse<Long>();
        List<RoleApplicationMenuSimple> roles = roleApplicationMenuApi.listData(
                Filter.eq("role.id", role)
        );
        if (roles != null) {
            result.setData(roles.stream().map(RoleApplicationMenuSimple::getMenu).collect(Collectors.toList()));
        }
        return result;
    }

    @Override
    public List<String> permissions(Long appId, Long role) {
        List<String> result = new ArrayList<>();
        List<RoleApplicationMenu> roles = roleApplicationMenuRepository.findByRoleId(role);
        if (roles != null) {
            for (RoleApplicationMenu menu : roles) {
                ApplicationMenu menuItem = menu.getMenu();
                if (menuItem != null && StringUtils.hasText(menuItem.getPermission())) {
                    result.addAll(Arrays.asList(menuItem.getPermission().split(",")));
                }
            }
        }
        return result;
    }

    @Override
    public ListResponse<String> selectPermissionByUser(Long appId, Long userId) {
        ListResponse<String> result = new ListResponse<>();
        List<ApplicationMenuSimple> list = applicationMenuMapper.findByUser(appId, userId);
        if (list != null) {
            for (ApplicationMenuSimple menuSimple : list) {
                if (StringUtils.hasText(menuSimple.getPermission())) {
                    result.getData().addAll(Arrays.asList(menuSimple.getPermission().split(",")));
                }
            }
        }
        return result;
    }

    @Override
    public ResponseObject<?> updateRoleMenus(UpdateRoleMenuRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        RoleResponse role = roleApi.oneData(Filter.eq("id", request.getRoleId()));
        if (role == null) {
            result.setCode(501);
            result.setMsg("无效角色id");
            return result;
        }
        roleApplicationMenuApi.deleteByFilter(Filter.eq(RoleMenuField.role, request.getRoleId()));

        for (Long menu : request.getMenus()) {
            RoleApplicationMenuDataRequest form = new RoleApplicationMenuDataRequest();
            form.setRole(request.getRoleId());
            form.setMenu(menu);
            roleApplicationMenuApi.createData(form);
        }

        return result;
    }

    @Override
    public ResponseObject<?> drag(MenuDragRequest request) {
        return null;
    }
}
