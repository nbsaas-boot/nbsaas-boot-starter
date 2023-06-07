package com.nbsaas.boot.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class UserOauthTokenSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



            /**
            * 
            **/
                private String access_token;

            /**
            * 
            **/
                private String refresh_token;

            /**
            * 
            **/
                private String uid;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 
            **/
                private String token_type;

            /**
            * 
            **/
                private Long expires_in;

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
                private Integer loginSize;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


    }