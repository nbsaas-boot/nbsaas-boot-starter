package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuDataRequest;
import com.nbsaas.boot.system.data.entity.Application;
import com.nbsaas.boot.system.data.entity.ApplicationMenu;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
 * 请求对象转换成实体对象
 */

public class ApplicationMenuEntityConvert implements Converter<ApplicationMenu, ApplicationMenuDataRequest> {
    @Override
    public ApplicationMenu convert(ApplicationMenuDataRequest source) {
        ApplicationMenu result = new ApplicationMenu();
        BeanDataUtils.copyProperties(source, result);
        if (source.getApp() != null) {
            Application app = new Application();
            app.setId(source.getApp());
            result.setApp(app);
        }
        return result;
    }
}

