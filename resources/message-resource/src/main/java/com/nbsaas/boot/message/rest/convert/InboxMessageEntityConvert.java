package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxMessage;
import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.jpa.data.entity.User;
            import com.nbsaas.boot.jpa.data.entity.User;
            import com.nbsaas.boot.message.data.entity.Inbox;

/**
* 请求对象转换成实体对象
*/

public class InboxMessageEntityConvert  implements Converter<InboxMessage, InboxMessageDataRequest> {

    @Override
    public InboxMessage convert(InboxMessageDataRequest source) {
        InboxMessage result = new InboxMessage();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getToUser()!=null){
                    User toUser =new User();
                    toUser.setId(source.getToUser());
                    result.setToUser(toUser);
                    }
                    if(source.getSendUser()!=null){
                    User sendUser =new User();
                    sendUser.setId(source.getSendUser());
                    result.setSendUser(sendUser);
                    }
                    if(source.getInbox()!=null){
                    Inbox inbox =new Inbox();
                    inbox.setId(source.getInbox());
                    result.setInbox(inbox);
                    }
        return result;
    }
}

