package com.nbsaas.boot.user.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.user.api.domain.enums.SecurityType;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class UserPasswordResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        /**
        * 
        **/
            private String password;

        /**
        * 
        **/
            private String salt;

        /**
        * 
        **/
            //枚举
            private SecurityType securityType;

            private String securityTypeName;

        /**
        * 
        **/
            private Integer checkSize;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 
        **/
            private Long user;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;

}