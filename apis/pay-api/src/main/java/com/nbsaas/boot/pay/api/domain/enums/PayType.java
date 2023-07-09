package com.nbsaas.boot.pay.api.domain.enums;

public enum PayType {

    shop, platform;

    @Override
    public String toString() {
        if (name().equals("shop")) {
            return "微信直连";
        } else if (name().equals("platform")) {
            return "服务商";
        } else {
            return super.toString();
        }
    }
}
