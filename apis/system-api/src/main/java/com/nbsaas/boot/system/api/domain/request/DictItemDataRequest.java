package com.nbsaas.boot.system.api.domain.request;

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
public class DictItemDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;



        /**
        * 
        **/
            //private String dictTitleTitle;

        /**
        * 键值
        **/
            private String dataValue;

        /**
        * 
        **/
            private Long dict;

        /**
        * 排序字段
        **/
            private Integer sortNum;

        /**
        * 
        **/
            private StoreState storeState;

        /**
        * 主键id
        **/
            private Long id;

        /**
        * 编码
        **/
            private String dataCode;

        /**
        * 添加时间
        **/
            private Date addDate;

        /**
        * 最新修改时间
        **/
            private Date lastDate;
}