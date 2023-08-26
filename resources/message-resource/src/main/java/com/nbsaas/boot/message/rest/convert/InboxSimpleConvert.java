package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.Inbox;
import com.nbsaas.boot.message.api.domain.simple.InboxSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class InboxSimpleConvert implements Converter<InboxSimple, Inbox> {




@Override
public InboxSimple convert(Inbox source) {
    InboxSimple result = new InboxSimple();

                if(source.getInboxTemplate()!=null){
                    result.setInboxTemplate(source.getInboxTemplate().getId());
                }
                result.setDataKey(source.getDataKey());
                result.setUnReadNum(source.getUnReadNum());
                if(source.getInboxTemplate()!=null){
                    result.setInboxTemplateName(source.getInboxTemplate().getName());
                }
                result.setTotalNum(source.getTotalNum());
                result.setName(source.getName());
                result.setIcon(source.getIcon());
                result.setId(source.getId());
                result.setUserId(source.getUserId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}