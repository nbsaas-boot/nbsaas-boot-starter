package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.StoreState;
            import com.nbsaas.boot.user.api.domain.enums.LoginState;
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
            private String note;

        /**
        * 
        **/
            private String password;

        /**
        * 
        **/
            private String ip;

        /**
        * 
        **/
            private String client;

        /**
        * 
        **/
            private StoreState storeState;

        /**
        * 
        **/
            private LoginState state;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            //private String userNameName;

        /**
        * 
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 
        **/
            private String account;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}