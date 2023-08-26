package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxTemplate;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class InboxTemplateResponseConvert  implements Converter<InboxTemplateResponse,InboxTemplate> {

    @Override
    public InboxTemplateResponse convert(InboxTemplate source) {
        InboxTemplateResponse  result = new  InboxTemplateResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}

