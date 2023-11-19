package com.nbsaas.boot.system.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.system.api.apis.ApplicationApi;
import com.nbsaas.boot.system.api.domain.field.ApplicationField;
import com.nbsaas.boot.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationResponse;
import com.nbsaas.boot.system.ext.apis.ApplicationExtApi;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class ApplicationExtResource implements ApplicationExtApi {

    @Resource
    private ApplicationApi applicationApi;

    @Override
    public ResponseObject<ApplicationResponse> create(ApplicationDataRequest request) {
        ResponseObject<ApplicationResponse> result = new ResponseObject<>();
        if (!StringUtils.hasText(request.getAppKey())) {
            result.setCode(501);
            result.setMsg("应用标识不能为空");
            return result;
        }

        Long num = applicationApi.countData(Filter.eq(ApplicationField.appKey, request.getAppKey()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setCode(501);
            result.setMsg(String.format("标识%s已经使用过了", request.getAppKey()));
            return result;
        }

        return applicationApi.create(request);
    }

    @Override
    public ResponseObject<ApplicationResponse> update(ApplicationDataRequest request) {
        ResponseObject<ApplicationResponse> result = new ResponseObject<>();
        if (StringUtils.hasText(request.getAppKey())) {
            Long num = applicationApi.countData(
                    Filter.eq(ApplicationField.appKey, request.getAppKey()),
                    Filter.ne("id", request.getId())
            );
            if (num == null) {
                num = 0L;
            }
            if (num > 0) {
                result.setCode(501);
                result.setMsg(String.format("标识%s已经使用过了", request.getAppKey()));
                return result;
            }
        }
        return applicationApi.update(request);
    }
}
