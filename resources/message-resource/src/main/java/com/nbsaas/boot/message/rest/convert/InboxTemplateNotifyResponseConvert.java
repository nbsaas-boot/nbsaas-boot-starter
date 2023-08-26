package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxTemplateNotify;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateNotifyResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class InboxTemplateNotifyResponseConvert  implements Converter<InboxTemplateNotifyResponse,InboxTemplateNotify> {

    @Override
    public InboxTemplateNotifyResponse convert(InboxTemplateNotify source) {
        InboxTemplateNotifyResponse  result = new  InboxTemplateNotifyResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getInboxTemplate()!=null){
                        result.setInboxTemplate(source.getInboxTemplate().getId());
                    }
        return result;
    }

}

