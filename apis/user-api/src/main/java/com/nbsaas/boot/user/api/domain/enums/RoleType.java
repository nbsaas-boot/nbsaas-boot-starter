package com.nbsaas.boot.user.api.domain.enums;

public enum RoleType {
    system, custom;

    @Override
    public String toString() {
        if (name().equals("SYSTEM")) {
            return "系统";
        } else if (name().equals("CUSTOM")) {
            return "自定义";
        }
        return super.toString();
    }
}
