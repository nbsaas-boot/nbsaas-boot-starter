package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.Inbox;
import com.nbsaas.boot.message.api.domain.response.InboxResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class InboxResponseConvert  implements Converter<InboxResponse,Inbox> {

    @Override
    public InboxResponse convert(Inbox source) {
        InboxResponse  result = new  InboxResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getInboxTemplate()!=null){
                        result.setInboxTemplate(source.getInboxTemplate().getId());
                    }
                    if(source.getInboxTemplate()!=null){
                        result.setInboxTemplateName(source.getInboxTemplate().getName());
                    }
        return result;
    }

}

