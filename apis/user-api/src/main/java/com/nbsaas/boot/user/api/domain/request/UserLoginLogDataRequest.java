package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.user.api.domain.enums.LoginState;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 请求对象
*/
@Data
public class UserLoginLogDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
        private Long user;

        /**
        * 
        **/
        private LoginState state;

        /**
        * 最新修改时间
        **/
        private Date lastDate;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 
        **/
        private StoreState storeState;

        /**
        * 
        **/
        private String client;

        /**
        * 
        **/
        private String note;

        /**
        * 
        **/
        private String account;

        /**
        * 
        **/
        private String ip;

        /**
        * 
        **/
        private String userName;

        /**
        * 
        **/
        private String password;

        /**
        * 添加时间
        **/
        private Date addDate;
}