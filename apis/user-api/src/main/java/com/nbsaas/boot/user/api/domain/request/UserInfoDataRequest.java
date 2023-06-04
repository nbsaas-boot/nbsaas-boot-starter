package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.State;
            import com.nbsaas.boot.rest.enums.DataScope;
            import com.nbsaas.boot.rest.enums.StoreState;
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
        * 最新修改时间
        **/
        private Date lastDate;

        /**
        * 
        **/
        private State state;

        /**
        * 
        **/
        private String structureName;

        /**
        * 
        **/
        private String note;

        /**
        * 
        **/
        private String phone;

        /**
        * 
        **/
        private Integer catalog;

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
        private String avatar;

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
        private String name;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 
        **/
        private StoreState storeState;
}