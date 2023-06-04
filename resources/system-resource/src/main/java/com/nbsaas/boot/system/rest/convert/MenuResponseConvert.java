package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.Menu;
import com.nbsaas.boot.system.api.domain.response.MenuResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class MenuResponseConvert  implements Converter
<MenuResponse,Menu> {

@Override
public MenuResponse convert(Menu source) {
MenuResponse  result = new  MenuResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getParent()!=null){
            result.setParent(source.getParent().getId());
            }
return result;
}

}

