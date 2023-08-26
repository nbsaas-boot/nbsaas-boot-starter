package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxMessage;
import com.nbsaas.boot.message.api.domain.response.InboxMessageResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class InboxMessageResponseConvert  implements Converter<InboxMessageResponse,InboxMessage> {

    @Override
    public InboxMessageResponse convert(InboxMessage source) {
        InboxMessageResponse  result = new  InboxMessageResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getToUser()!=null){
                        result.setToUser(source.getToUser().getId());
                    }
                    if(source.getSendUser()!=null){
                        result.setSendUser(source.getSendUser().getId());
                    }
                    if(source.getSendUser()!=null){
                        result.setSendUserName(source.getSendUser().getName());
                    }
                    if(source.getToUser()!=null){
                        result.setToUserName(source.getToUser().getName());
                    }
                    if(source.getInbox()!=null){
                        result.setInbox(source.getInbox().getId());
                    }
        return result;
    }

}

