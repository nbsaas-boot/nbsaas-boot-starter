package com.nbsaas.boot.system.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.apis.MenuApi;
import com.nbsaas.boot.system.api.apis.RoleApi;
import com.nbsaas.boot.system.api.apis.RoleMenuApi;
import com.nbsaas.boot.system.api.domain.field.RoleMenuField;
import com.nbsaas.boot.system.api.domain.request.MenuDataRequest;
import com.nbsaas.boot.system.api.domain.request.RoleMenuDataRequest;
import com.nbsaas.boot.system.api.domain.response.MenuResponse;
import com.nbsaas.boot.system.api.domain.response.RoleResponse;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;
import com.nbsaas.boot.system.api.domain.simple.RoleMenuSimple;
import com.nbsaas.boot.system.data.entity.Menu;
import com.nbsaas.boot.system.data.entity.RoleMenu;
import com.nbsaas.boot.system.data.mapper.MenuMapper;
import com.nbsaas.boot.system.data.repository.MenuRepository;
import com.nbsaas.boot.system.data.repository.RoleMenuRepository;
import com.nbsaas.boot.system.ext.apis.MenuExtApi;
import com.nbsaas.boot.system.ext.domain.request.MenuDragRequest;
import com.nbsaas.boot.system.ext.domain.request.UpdateRoleMenuRequest;
import com.nbsaas.boot.system.ext.domain.simple.MenuExtSimple;
import com.nbsaas.boot.system.rest.convert.MenuSimpleConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class MenuExtResource implements MenuExtApi {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private RoleMenuRepository roleMenuRepository;

    @Resource
    private RoleMenuApi roleMenuApi;

    @Resource
    private RoleApi roleApi;

    @Resource
    private MenuApi menuApi;


    @Transactional(readOnly = true)
    @Override
    public ListResponse<MenuExtSimple> tree(Long userId, Integer version) {
        ListResponse<MenuExtSimple> result = new ListResponse<>();
        if (version == null) {
            version = 1;
        }
        List<MenuSimple> list;
        if (version == 1) {
            list = menuMapper.findByUser(userId);
        } else {
            list = menuMapper.findByUser2(userId);
        }
        if (list != null) {
            result.setData(makeTree(list));
        }
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public ListResponse<MenuExtSimple> root() {
        ListResponse<MenuExtSimple> result = new ListResponse<>();
        List<Menu> all = menuRepository.findAll();
        List<MenuSimple> list = all.stream().map(new MenuSimpleConvert()).collect(Collectors.toList());
        result.setData(makeTree(list));
        return result;
    }

    @Override
    public ListResponse<MenuExtSimple> findByRole(Long role) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public ListResponse<Long> selectForPermission(Long role) {
        ListResponse<Long> result = new ListResponse<Long>();
        List<RoleMenuSimple> roles = roleMenuApi.listData(Filter.eq("role.id", role));
        if (roles != null) {
            result.setData(roles.stream().map(RoleMenuSimple::getMenu).collect(Collectors.toList()));
        }
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public List<String> permissions(Long role) {
        List<String> result = new ArrayList<>();
        List<RoleMenu> roles = roleMenuRepository.findByRoleId(role);
        if (roles != null) {
            List<String> menus = roles.stream().map(RoleMenu::getMenu).map(Menu::getPermission).collect(Collectors.toList());
            result.addAll(menus);
        }
        return result;
    }

    @Override
    public ListResponse<String> selectPermissionByUser(Long userId) {
        return null;
    }

    @Transactional
    @Override
    public ResponseObject<?> updateRoleMenus(UpdateRoleMenuRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        RoleResponse role = roleApi.oneData(Filter.eq("id", request.getRoleId()));
        if (role == null) {
            result.setCode(501);
            result.setMsg("无效角色id");
            return result;
        }
        roleMenuApi.deleteByFilter(Filter.eq(RoleMenuField.role, request.getRoleId()));

        for (Long menu : request.getMenus()) {
            RoleMenuDataRequest form = new RoleMenuDataRequest();
            form.setRole(request.getRoleId());
            form.setMenu(menu);
            roleMenuApi.createData(form);
        }

        return result;
    }

    @Transactional
    @Override
    public ResponseObject<?> drag(MenuDragRequest request) {
        ResponseObject<?> result = new ResponseObject<>();
        Optional<Menu> menuOptional = menuRepository.findById(request.getMenu());
        if (!menuOptional.isPresent()) {
            result.setCode(501);
            result.setMsg("拖动菜单无效");
            return result;
        }
        Optional<Menu> targetOptional = menuRepository.findById(request.getTarget());
        if (!targetOptional.isPresent()) {
            result.setCode(501);
            result.setMsg("拖动菜单无效");
            return result;
        }
        Menu menu=menuOptional.get();
        Menu target=targetOptional.get();

        if ("inner".equals(request.getDropType())) {
            menu.setParent(target.getParent());
        } else {
            Integer sortNum1;
            Integer sortNum2 = target.getSortNum();
            if (sortNum2 == null) {
                sortNum2 = 0;
            }

            if ("before".equals(request.getDropType())) {
                sortNum1 = sortNum2;
                sortNum2 = sortNum1 + 1;
            } else {
                sortNum1 = sortNum2 + 1;
            }
            //判断移动是否是同一层级
            menu.setSortNum(sortNum1);
            menu.setParent(target.getParent());

            StringBuffer ids=new StringBuffer();
            if (target.getParent()!=null){
                Menu parent =target.getParent();
                if (parent.getIds() != null) {
                    ids.append(parent.getIds());
                    ids.append("-");
                } else {
                    ids.append(parent.getId());
                    ids.append("-");
                }
            }
            menu.setIds(ids.toString());


            target.setSortNum(sortNum2);
        }

        return result;
    }

    private List<MenuExtSimple> makeTree(List<MenuSimple> menuList) {
        List<MenuExtSimple> tree = new ArrayList<>();
        if (menuList != null && menuList.size() > 0) {
            List<MenuExtSimple> ls = menuList.stream().map(item -> {
                MenuExtSimple simple = new MenuExtSimple();
                BeanUtils.copyProperties(item, simple);
                if (simple.getSortNum() == null) {
                    simple.setSortNum(0);
                }
                return simple;
            }).collect(Collectors.toList());
            Map<Long, MenuExtSimple> map = new HashMap<>();
            for (MenuExtSimple item : ls) {
                map.put(item.getId(), item);
            }
            for (MenuExtSimple item : ls) {
                if (item.getParent() == null) {
                    tree.add(item);
                } else {
                    MenuExtSimple parent = map.get(item.getParent());
                    if (parent != null) {
                        if (parent.getChildren() == null) {
                            parent.setChildren(new ArrayList<>());
                        }
                        parent.getChildren().add(item);
                    }
                }
            }

        }
        tree.sort(Comparator.comparingLong(MenuExtSimple::getSortNum));

        for (MenuExtSimple menuExtSimple : tree) {
            if (menuExtSimple.getChildren() != null) {
                menuExtSimple.getChildren().sort(Comparator.comparingLong(MenuSimple::getSortNum));
            }
        }

        return tree;
    }
}
