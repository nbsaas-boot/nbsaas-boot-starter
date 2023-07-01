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
            * 
            **/
                private Long consumeTime;

            /**
            * 
            **/
                private Long creator;

            /**
            * 
            **/
                private String ip;

            /**
            * 
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
            * 
            **/
                private String url;

            /**
            * 最新修改时间
            **/
                private Date lastDate;


}