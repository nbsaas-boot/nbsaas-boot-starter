package com.nbsaas.boot.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.DataScope;
            import com.nbsaas.boot.rest.enums.StoreState;
            import com.nbsaas.boot.rest.enums.State;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserInfoResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 用户介绍
        **/
            private String note;

        /**
        * 用户类型
        **/
            private Integer catalog;

        /**
        * 所在组织
        **/
            private String structureName;

        /**
        * 用户头像
        **/
            private String avatar;

        /**
        * 
        **/
            //枚举
            private DataScope dataScope;

            private String dataScopeName;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 所在组织
        **/
            private Long structure;

        /**
        * 用户登录次数
        **/
            private Integer loginSize;

        /**
        * 手机号码
        **/
            private String phone;

        /**
        * 账号
        **/
            private String accountNo;

        /**
        * 用户真实姓名
        **/
            private String name;

        /**
        * 
        **/
            //枚举
            private StoreState storeState;

            private String storeStateName;

        /**
        * 
        **/
            //枚举
            private State state;

            private String stateName;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}