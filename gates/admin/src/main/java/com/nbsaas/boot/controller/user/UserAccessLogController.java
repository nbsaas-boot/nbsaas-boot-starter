package com.nbsaas.boot.controller.user;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserAccessLogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserAccessLogSimple;
import com.nbsaas.boot.user.api.apis.UserAccessLogApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
*  对外控制器
*/
@RequiresAuthentication
@RestController
@RequestMapping("/userAccessLog")
public class UserAccessLogController {


    @Resource
    private UserAccessLogApi userAccessLogApi;


    @RequestMapping("/search")
    public PageResponse <UserAccessLogSimple> search(UserAccessLogSearchRequest request) {
        return userAccessLogApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<UserAccessLogSimple> list(UserAccessLogSearchRequest request) {
        return userAccessLogApi.list(request);
    }

    /**
    * 添加数据
    *
    * @param request
    * @return
    */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject <UserAccessLogResponse> create(@Validated(AddOperator.class) UserAccessLogDataRequest request) {
        return userAccessLogApi.create(request);
    }

   @UpdateData
   @RequestMapping("/update")
   public ResponseObject<UserAccessLogResponse> update(@Validated(UpdateOperator.class) UserAccessLogDataRequest request) {
       return userAccessLogApi.update(request);
   }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) UserAccessLogDataRequest request) {
        return userAccessLogApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject <UserAccessLogResponse> view(@Validated(ViewOperator.class) UserAccessLogDataRequest  request) {
        return userAccessLogApi.view(request);
    }
}