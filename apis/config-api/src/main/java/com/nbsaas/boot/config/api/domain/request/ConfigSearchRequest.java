package com.nbsaas.boot.config.api.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.rest.request.PageRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 搜索bean
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ConfigSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    /**
     * 配置json数据
     **/
    @Search(name = "configData", operator = Operator.like)
    private String configData;

    /**
     * 配置类标识
     **/
    @Search(name = "className", operator = Operator.like)
    private String className;

    /**
     * 主键id
     **/
    @Search(name = "id", operator = Operator.eq)
    private Long id;


}