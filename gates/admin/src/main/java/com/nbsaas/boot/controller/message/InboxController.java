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
import com.nbsaas.boot.message.api.domain.request.InboxDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxSearchRequest;
import com.nbsaas.boot.message.api.domain.response.InboxResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxSimple;
import com.nbsaas.boot.message.api.apis.InboxApi;
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
@RequestMapping("/inbox")
public class InboxController {


    @Resource
    private InboxApi inboxApi;


    @RequiresPermissions("inbox")
    @RequestMapping("/search")
    public PageResponse <InboxSimple> search(InboxSearchRequest request) {
        return inboxApi.search(request);
    }

    @RequiresPermissions("inbox")
    @RequestMapping("/list")
    public ListResponse<InboxSimple> list(InboxSearchRequest request) {
        return inboxApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @RequiresPermissions("inbox")
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <InboxResponse> create(@Validated(AddOperator.class) InboxDataRequest request) {
        return inboxApi.create(request);
    }

   @RequiresPermissions("inbox")
   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<InboxResponse> update(@Validated(UpdateOperator.class) InboxDataRequest request) {
       return inboxApi.update(request);
   }

    @RequiresPermissions("inbox")
    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) InboxDataRequest request) {
        return inboxApi.delete(request);
    }

    @RequiresPermissions("inbox")
    @RequestMapping("/view")
    public ResponseObject <InboxResponse> view(@Validated(ViewOperator.class) InboxDataRequest  request) {
        return inboxApi.view(request);
    }
}