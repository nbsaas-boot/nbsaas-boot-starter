package com.nbsaas.boot.pay.api.domain.enums;

public enum FeeType {
    single,scale;

    @Override
    public String toString() {
        if (name().equals("single")) {
            return "单笔扣费";
        } else if (name().equals("scale")) {
            return "百分比";
        } else {
            return super.toString();
        }
    }
}
