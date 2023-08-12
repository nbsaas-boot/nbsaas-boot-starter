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
            * 消耗时间
            **/
                private Long consumeTime;

            /**
            * 用户
            **/
                private Long creator;

            /**
            * ip地址
            **/
                private String ip;

            /**
            * 用户
            **/
                private String creatorName;

            /**
            * 
            **/
                private StoreState storeState;

                private String storeStateName;

            /**
            * 主键id
            **/
                private Long id;

            /**
            * 添加时间
            **/
                private Date addDate;

            /**
            * url地址
            **/
                private String url;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}