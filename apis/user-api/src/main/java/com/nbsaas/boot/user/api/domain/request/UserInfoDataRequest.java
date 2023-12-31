package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.DataScope;
            import com.nbsaas.boot.rest.enums.StoreState;
            import com.nbsaas.boot.rest.enums.State;
/**
* 请求对象
*/
@Data
public class UserInfoDataRequest implements Serializable,RequestId {

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
            //private String structureNameName;

        /**
        * 用户头像
        **/
            private String avatar;

        /**
        * 
        **/
            private DataScope dataScope;

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
            private StoreState storeState;

        /**
        * 
        **/
            private State state;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}