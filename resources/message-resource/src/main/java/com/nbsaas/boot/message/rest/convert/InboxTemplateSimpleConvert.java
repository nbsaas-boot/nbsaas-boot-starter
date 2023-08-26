package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.InboxTemplate;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class InboxTemplateSimpleConvert implements Converter<InboxTemplateSimple, InboxTemplate> {




@Override
public InboxTemplateSimple convert(InboxTemplate source) {
    InboxTemplateSimple result = new InboxTemplateSimple();

                result.setDataKey(source.getDataKey());
                result.setName(source.getName());
                result.setIcon(source.getIcon());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setLastDate(source.getLastDate());


    return result;
}

}