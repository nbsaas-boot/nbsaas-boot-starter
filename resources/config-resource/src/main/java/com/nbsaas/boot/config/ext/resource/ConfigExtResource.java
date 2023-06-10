package com.nbsaas.boot.config.ext.resource;

import com.google.gson.Gson;
import com.nbsaas.boot.config.data.entity.Config;
import com.nbsaas.boot.config.data.repository.ConfigRepository;
import com.nbsaas.boot.config.ext.apis.ConfigExtApi;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class ConfigExtResource implements ConfigExtApi {

    @Resource
    private ConfigRepository configRepository;

    @Override
    public <T> T config(Class<T> classKey) {
        Config data = configRepository.findByClassName(classKey.getSimpleName());
        if (data == null) {
            T configData;
            try {
                configData = classKey.getConstructor().newInstance();
            } catch (Exception ignored) {
                return null;
            }
            data = new Config();
            data.setClassName(classKey.getSimpleName());
            data.setConfigData(new Gson().toJson(configData));
            data.setAddDate(new Date());
            data.setLastDate(new Date());
            configRepository.save(data);
            return configData;
        }
        String jsonData = data.getConfigData();
        if (jsonData == null) {
            jsonData = "{}";
        }

        return new Gson().fromJson(jsonData, classKey);
    }

    @Transactional
    @Override
    public <T> ResponseObject<T> info(Class<T> classKey) {
        ResponseObject<T> result = new ResponseObject<T>();
        result.setData(config(classKey));
        return result;
    }

    @Transactional
    @Override
    public <T> ResponseObject<T> configData(T data) {
        ResponseObject<T> result = new ResponseObject<T>();

        if (data == null) {
            result.setCode(501);
            result.setMsg("空数据");
            return result;
        }
        result.setData(data(data));
        return result;
    }

    @Override
    public <T> T data(T data) {
        if (data == null) {
            return null;
        }
        Config temp = configRepository.findByClassName(data.getClass().getSimpleName());

        if (temp == null) {
            temp = new Config();
            temp.setClassName(data.getClass().getSimpleName());
            temp.setConfigData(new Gson().toJson(data));
            configRepository.save(temp);
            return data;
        }
        temp.setConfigData(new Gson().toJson(data));
        temp.setLastDate(new Date());
        return data;
    }
}
