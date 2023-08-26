package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.TemplateWechat;
import com.nbsaas.boot.message.api.domain.response.TemplateWechatResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class TemplateWechatResponseConvert  implements Converter<TemplateWechatResponse,TemplateWechat> {

    @Override
    public TemplateWechatResponse convert(TemplateWechat source) {
        TemplateWechatResponse  result = new  TemplateWechatResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

