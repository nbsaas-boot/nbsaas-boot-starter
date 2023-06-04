package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class UserOauthTokenDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
        private Long expires_in;

        /**
        * 
        **/
        private Long user;

        /**
        * 最新修改时间
        **/
        private Date lastDate;

        /**
        * 
        **/
        private String token_type;

        /**
        * 
        **/
        private Integer loginSize;

        /**
        * 主键id
        **/
        private Long id;

        /**
        * 
        **/
        private String uid;

        /**
        * 
        **/
        private String refresh_token;

        /**
        * 
        **/
        private String access_token;

        /**
        * 添加时间
        **/
        private Date addDate;
}