package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxMessage;
import com.nbsaas.boot.message.api.domain.simple.InboxMessageSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class InboxMessageSimpleConvert implements Converter<InboxMessageSimple, InboxMessage> {




@Override
public InboxMessageSimple convert(InboxMessage source) {
    InboxMessageSimple result = new InboxMessageSimple();

                if(source.getToUser()!=null){
                    result.setToUser(source.getToUser().getId());
                }
                result.setNote(source.getNote());
                result.setExtData(source.getExtData());
                if(source.getSendUser()!=null){
                    result.setSendUser(source.getSendUser().getId());
                }
                if(source.getSendUser()!=null){
                    result.setSendUserName(source.getSendUser().getName());
                }
                if(source.getToUser()!=null){
                    result.setToUserName(source.getToUser().getName());
                }
                result.setState(source.getState());
                result.setId(source.getId());
                result.setTitle(source.getTitle());
                if(source.getInbox()!=null){
                    result.setInbox(source.getInbox().getId());
                }
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}