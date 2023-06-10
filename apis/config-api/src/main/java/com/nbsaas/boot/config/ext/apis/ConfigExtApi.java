package com.nbsaas.boot.config.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;

public interface ConfigExtApi {

    /**
     * 获取配置
     *
     * @param classKey
     * @param <T>
     * @return
     */
    <T> T config(Class<T> classKey);

    <T> ResponseObject<T> info(Class<T> classKey);

    <T> ResponseObject<T> configData(T data);

    <T> T data(T data);

}
