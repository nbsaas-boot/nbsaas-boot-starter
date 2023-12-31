package com.nbsaas.boot.controller.system;

import com.nbsaas.boot.rest.annotations.AddOperator;
import com.nbsaas.boot.rest.annotations.DeleteOperator;
import com.nbsaas.boot.rest.annotations.UpdateOperator;
import com.nbsaas.boot.rest.annotations.ViewOperator;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.rest.annotations.CreateData;
import com.nbsaas.boot.rest.annotations.UpdateData;
import com.nbsaas.boot.system.api.domain.request.ErrorLogDataRequest;
import com.nbsaas.boot.system.api.domain.request.ErrorLogSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ErrorLogResponse;
import com.nbsaas.boot.system.api.domain.simple.ErrorLogSimple;
import com.nbsaas.boot.system.api.apis.ErrorLogApi;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@RequiresAuthentication
@RestController
@RequestMapping("/app/errorLog")
public class ErrorLogAppController {


    @Resource
    private ErrorLogApi errorLogApi;


    @RequestMapping("/search")
    public PageResponse<ErrorLogSimple> search(ErrorLogSearchRequest request) {
        return errorLogApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<ErrorLogSimple> list(ErrorLogSearchRequest request) {
        return errorLogApi.list(request);
    }

    /**
     * 添加数据
     *
     * @param request
     * @return
     */
    @CreateData
    @RequestMapping("/create")
    public ResponseObject<ErrorLogResponse> create(@Validated(AddOperator.class) ErrorLogDataRequest request) {
        return errorLogApi.create(request);
    }

    @UpdateData
    @RequestMapping("/update")
    public ResponseObject<ErrorLogResponse> update(@Validated(UpdateOperator.class) ErrorLogDataRequest
                                                           request) {
        return errorLogApi.update(request);
    }

    @RequestMapping("/delete")
    public ResponseObject<?> delete(@Validated(DeleteOperator.class) ErrorLogDataRequest request) {
        return errorLogApi.delete(request);
    }

    @RequestMapping("/view")
    public ResponseObject<ErrorLogResponse> view(@Validated(ViewOperator.class) ErrorLogDataRequest request) {
        return errorLogApi.view(request);
    }

}
