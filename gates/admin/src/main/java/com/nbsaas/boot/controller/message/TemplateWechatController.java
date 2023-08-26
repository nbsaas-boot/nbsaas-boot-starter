package com.nbsaas.boot.controller.message;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.message.api.domain.request.TemplateWechatDataRequest;
import com.nbsaas.boot.message.api.domain.request.TemplateWechatSearchRequest;
import com.nbsaas.boot.message.api.domain.response.TemplateWechatResponse;
import com.nbsaas.boot.message.api.domain.simple.TemplateWechatSimple;
import com.nbsaas.boot.message.api.apis.TemplateWechatApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/templateWechat")
public class TemplateWechatController {


    @Resource
    private TemplateWechatApi templateWechatApi;


    @RequiresPermissions("templateWechat")
    @RequestMapping("/search")
    public PageResponse <TemplateWechatSimple> search(TemplateWechatSearchRequest request) {
        return templateWechatApi.search(request);
    }

    @RequiresPermissions("templateWechat")
    @RequestMapping("/list")
    public ListResponse<TemplateWechatSimple> list(TemplateWechatSearchRequest request) {
        return templateWechatApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("templateWechat")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <TemplateWechatResponse> create(@Validated(AddOperator.class) TemplateWechatDataRequest request) {
        return templateWechatApi.create(request);
    }

   @RequiresPermissions("templateWechat")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<TemplateWechatResponse> update(@Validated(UpdateOperator.class) TemplateWechatDataRequest request) {
       return templateWechatApi.update(request);
   }

    @RequiresPermissions("templateWechat")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) TemplateWechatDataRequest request) {
        return templateWechatApi.delete(request);
    }

    @RequiresPermissions("templateWechat")
    @RequestMapping("/view")
    public ResponseObject <TemplateWechatResponse> view(@Validated(ViewOperator.class) TemplateWechatDataRequest  request) {
        return templateWechatApi.view(request);
    }
}