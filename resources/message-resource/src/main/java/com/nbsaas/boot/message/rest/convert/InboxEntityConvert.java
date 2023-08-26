package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.Inbox;
import com.nbsaas.boot.message.api.domain.request.InboxDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.message.data.entity.InboxTemplate;

/**
* 请求对象转换成实体对象
*/

public class InboxEntityConvert  implements Converter<Inbox, InboxDataRequest> {

    @Override
    public Inbox convert(InboxDataRequest source) {
        Inbox result = new Inbox();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getInboxTemplate()!=null){
                    InboxTemplate inboxTemplate =new InboxTemplate();
                    inboxTemplate.setId(source.getInboxTemplate());
                    result.setInboxTemplate(inboxTemplate);
                    }
        return result;
    }
}

