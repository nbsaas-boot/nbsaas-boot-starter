package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxTemplateNotify;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateNotifySimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class InboxTemplateNotifySimpleConvert implements Converter<InboxTemplateNotifySimple, InboxTemplateNotify> {




@Override
public InboxTemplateNotifySimple convert(InboxTemplateNotify source) {
    InboxTemplateNotifySimple result = new InboxTemplateNotifySimple();

                if(source.getInboxTemplate()!=null){
                    result.setInboxTemplate(source.getInboxTemplate().getId());
                }
                result.setName(source.getName());
                result.setClassName(source.getClassName());
                result.setState(source.getState());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}