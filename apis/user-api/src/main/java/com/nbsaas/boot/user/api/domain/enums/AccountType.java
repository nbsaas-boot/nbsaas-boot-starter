package com.nbsaas.boot.user.api.domain.enums;

/**
 * 账号类型
 * <p>
 * Created by ada on 2016/12/15.
 */
public enum AccountType {
    phone, email, account;

    @Override
    public String toString() {
        if (name().equals("Phone")) {
            return "手机账号";
        } else if (name().equals("Email")) {
            return "邮件账号";
        } else if (name().equals("Account")) {
            return "普通账号";
        }
        return super.toString();
    }
}
