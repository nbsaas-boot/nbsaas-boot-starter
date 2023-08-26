package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxTemplate;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class InboxTemplateEntityConvert  implements Converter<InboxTemplate, InboxTemplateDataRequest> {

    @Override
    public InboxTemplate convert(InboxTemplateDataRequest source) {
        InboxTemplate result = new InboxTemplate();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}

