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
import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxMessageSearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxMessageResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxMessageSimple;
import com.nbsaas.boot.message.api.apis.InboxMessageApi;
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
@RequestMapping("/inboxMessage")
public class InboxMessageController {


    @Resource
    private InboxMessageApi inboxMessageApi;


    @RequiresPermissions("inboxMessage")
    @RequestMapping("/search")
    public PageResponse <InboxMessageSimple> search(InboxMessageSearchRequest request) {
        return inboxMessageApi.search(request);
    }

    @RequiresPermissions("inboxMessage")
    @RequestMapping("/list")
    public ListResponse<InboxMessageSimple> list(InboxMessageSearchRequest request) {
        return inboxMessageApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("inboxMessage")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <InboxMessageResponse> create(@Validated(AddOperator.class) InboxMessageDataRequest request) {
        return inboxMessageApi.create(request);
    }

   @RequiresPermissions("inboxMessage")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<InboxMessageResponse> update(@Validated(UpdateOperator.class) InboxMessageDataRequest request) {
       return inboxMessageApi.update(request);
   }

    @RequiresPermissions("inboxMessage")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) InboxMessageDataRequest request) {
        return inboxMessageApi.delete(request);
    }

    @RequiresPermissions("inboxMessage")
    @RequestMapping("/view")
    public ResponseObject <InboxMessageResponse> view(@Validated(ViewOperator.class) InboxMessageDataRequest  request) {
        return inboxMessageApi.view(request);
    }
}