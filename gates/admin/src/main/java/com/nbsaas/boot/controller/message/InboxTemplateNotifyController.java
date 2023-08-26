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
import com.nbsaas.boot.message.api.domain.request.InboxTemplateNotifyDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxTemplateNotifySearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateNotifyResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateNotifySimple;
import com.nbsaas.boot.message.api.apis.InboxTemplateNotifyApi;
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
@RequestMapping("/inboxTemplateNotify")
public class InboxTemplateNotifyController {


    @Resource
    private InboxTemplateNotifyApi inboxTemplateNotifyApi;


    @RequiresPermissions("inboxTemplateNotify")
    @RequestMapping("/search")
    public PageResponse <InboxTemplateNotifySimple> search(InboxTemplateNotifySearchRequest request) {
        return inboxTemplateNotifyApi.search(request);
    }

    @RequiresPermissions("inboxTemplateNotify")
    @RequestMapping("/list")
    public ListResponse<InboxTemplateNotifySimple> list(InboxTemplateNotifySearchRequest request) {
        return inboxTemplateNotifyApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("inboxTemplateNotify")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <InboxTemplateNotifyResponse> create(@Validated(AddOperator.class) InboxTemplateNotifyDataRequest request) {
        return inboxTemplateNotifyApi.create(request);
    }

   @RequiresPermissions("inboxTemplateNotify")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<InboxTemplateNotifyResponse> update(@Validated(UpdateOperator.class) InboxTemplateNotifyDataRequest request) {
       return inboxTemplateNotifyApi.update(request);
   }

    @RequiresPermissions("inboxTemplateNotify")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) InboxTemplateNotifyDataRequest request) {
        return inboxTemplateNotifyApi.delete(request);
    }

    @RequiresPermissions("inboxTemplateNotify")
    @RequestMapping("/view")
    public ResponseObject <InboxTemplateNotifyResponse> view(@Validated(ViewOperator.class) InboxTemplateNotifyDataRequest  request) {
        return inboxTemplateNotifyApi.view(request);
    }
}