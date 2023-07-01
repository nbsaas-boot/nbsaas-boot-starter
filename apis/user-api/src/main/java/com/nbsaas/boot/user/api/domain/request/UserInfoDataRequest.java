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
            //private String structureNameName;

        /**
        * 
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