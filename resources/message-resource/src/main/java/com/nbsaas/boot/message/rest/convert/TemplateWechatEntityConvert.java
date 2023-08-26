package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.TemplateWechat;
import com.nbsaas.boot.message.api.domain.request.TemplateWechatDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TemplateWechatEntityConvert  implements Converter<TemplateWechat, TemplateWechatDataRequest> {

    @Override
    public TemplateWechat convert(TemplateWechatDataRequest source) {
        TemplateWechat result = new TemplateWechat();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

