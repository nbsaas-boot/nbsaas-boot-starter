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
        * 
        **/
            private String note;

        /**
        * 
        **/
            private Integer catalog;

        /**
        * 
        **/
            private String structureName;

        /**
        * 
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
        * 
        **/
            private Long structure;

        /**
        * 
        **/
            private Integer loginSize;

        /**
        * 
        **/
            private String phone;

        /**
        * 
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