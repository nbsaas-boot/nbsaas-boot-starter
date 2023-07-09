package com.nbsaas.boot.pay.api.domain.enums;

public enum OrderStatus {

    /** 未确认 */
    unconfirmed,

    /** 已确认 */
    confirmed,

    /** 已完成 */
    completed,

    /** 已取消 */
    cancelled
}
