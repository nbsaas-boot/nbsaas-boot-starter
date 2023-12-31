package com.nbsaas.boot.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;

/**
* 列表对象
*/
@Data
public class UserOauthConfigSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;




            /**
            * 第三方登陆名称
            **/
                private String name;

            /**
            * 第三方登陆标识
            **/
                private String model;

            /**
            * 程序key
            **/
                private String appKey;

            /**
            * 程序密钥
            **/
                private String appSecret;

            /**
            * java实现类
            **/
                private String className;

            /**
            * 启用状态  1启用 2未启用
            **/
                private Integer state;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}