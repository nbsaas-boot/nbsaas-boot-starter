package com.nbsaas.boot.system.ext.domain.request;

import lombok.Data;

@Data
public class MenuDragRequest {

    /**
     * 拖动到菜单id
     */
    private Long target;

    /**
     * 拖动菜单id
     */
    private Long menu;

    /**
     * 拖动类型
     */
    private String dropType;
}
