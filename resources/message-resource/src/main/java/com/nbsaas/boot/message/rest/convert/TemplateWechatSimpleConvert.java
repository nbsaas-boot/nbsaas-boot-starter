package com.nbsaas.boot.message.rest.convert;

import com.nbsaas.boot.message.data.entity.TemplateWechat;
import com.nbsaas.boot.message.api.domain.simple.TemplateWechatSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class TemplateWechatSimpleConvert implements Converter<TemplateWechatSimple, TemplateWechat> {




@Override
public TemplateWechatSimple convert(TemplateWechat source) {
    TemplateWechatSimple result = new TemplateWechatSimple();

                result.setCode(source.getCode());
                result.setName(source.getName());
                result.setId(source.getId());
                result.setAddDate(source.getAddDate());
                result.setContent(source.getContent());
                result.setLastDate(source.getLastDate());


    return result;
}

}