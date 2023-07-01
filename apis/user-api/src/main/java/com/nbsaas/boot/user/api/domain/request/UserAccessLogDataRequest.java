package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 请求对象
*/
@Data
public class UserAccessLogDataRequest implements Serializable,RequestId {

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
            //private String creatorNameName;

        /**
        * 
        **/
            private StoreState storeState;

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