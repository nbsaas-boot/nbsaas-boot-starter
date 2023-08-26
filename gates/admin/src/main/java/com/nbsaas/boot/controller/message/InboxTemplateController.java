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
import com.nbsaas.boot.message.api.domain.request.InboxTemplateDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateSearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateSimple;
import com.nbsaas.boot.message.api.apis.InboxTemplateApi;
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
@RequestMapping("/inboxTemplate")
public class InboxTemplateController {


    @Resource
    private InboxTemplateApi inboxTemplateApi;


    @RequiresPermissions("inboxTemplate")
    @RequestMapping("/search")
    public PageResponse <InboxTemplateSimple> search(InboxTemplateSearchRequest request) {
        return inboxTemplateApi.search(request);
    }

    @RequiresPermissions("inboxTemplate")
    @RequestMapping("/list")
    public ListResponse<InboxTemplateSimple> list(InboxTemplateSearchRequest request) {
        return inboxTemplateApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("inboxTemplate")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <InboxTemplateResponse> create(@Validated(AddOperator.class) InboxTemplateDataRequest request) {
        return inboxTemplateApi.create(request);
    }

   @RequiresPermissions("inboxTemplate")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<InboxTemplateResponse> update(@Validated(UpdateOperator.class) InboxTemplateDataRequest request) {
       return inboxTemplateApi.update(request);
   }

    @RequiresPermissions("inboxTemplate")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) InboxTemplateDataRequest request) {
        return inboxTemplateApi.delete(request);
    }

    @RequiresPermissions("inboxTemplate")
    @RequestMapping("/view")
    public ResponseObject <InboxTemplateResponse> view(@Validated(ViewOperator.class) InboxTemplateDataRequest  request) {
        return inboxTemplateApi.view(request);
    }
}