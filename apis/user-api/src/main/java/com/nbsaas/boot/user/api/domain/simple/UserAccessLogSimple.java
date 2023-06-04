package com.nbsaas.boot.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.rest.enums.StoreState;

/**
* 列表对象
*/
@Data
public class UserAccessLogSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



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
            private String url;

            /**
            * 
            **/
            private String ip;

            /**
            * 
            **/
            private Long creator;

            /**
            * 
            **/
            private String creatorName;

            /**
            * 
            **/
            private Long consumeTime;

            /**
            * 添加时间
            **/
            private Date addDate;


    }