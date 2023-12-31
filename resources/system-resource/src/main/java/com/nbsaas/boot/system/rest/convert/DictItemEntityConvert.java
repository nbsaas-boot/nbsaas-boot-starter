package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.system.data.entity.DictItem;
import com.nbsaas.boot.system.api.domain.request.DictItemDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;
            import com.nbsaas.boot.system.data.entity.Dict;

/**
* 请求对象转换成实体对象
*/

public class DictItemEntityConvert  implements Converter<DictItem, DictItemDataRequest> {

    @Override
    public DictItem convert(DictItemDataRequest source) {
        DictItem result = new DictItem();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getDict()!=null){
                    Dict dict =new Dict();
                    dict.setId(source.getDict());
                    result.setDict(dict);
                    }
        return result;
    }
}

