package com.nbsaas.boot.system.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class RoleMenuDataRequest implements Serializable,RequestId {

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
        * 菜单id
        **/
        private Long menu;

        /**
        * 角色id
        **/
        private Long role;

        /**
        * 添加时间
        **/
        private Date addDate;
}