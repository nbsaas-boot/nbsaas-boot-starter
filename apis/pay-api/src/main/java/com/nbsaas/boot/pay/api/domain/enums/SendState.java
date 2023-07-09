package com.nbsaas.boot.pay.api.domain.enums;

public enum SendState {

    init,send,fail,back;

    @Override
    public String toString() {
        if (name().equals("init")){
            return "未发放";
        }
        else if (name().equals("send")){
            return "已发放";
        }
        else if (name().equals("fail")){
            return "发放失败";
        } else if (name().equals("back")){
            return "提现退回";
        }
        return super.toString();
    }
}
