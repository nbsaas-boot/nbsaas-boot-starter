package com.nbsaas.boot.message.api.apis;

import com.nbsaas.boot.message.api.domain.request.InboxTemplateDataRequest;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateSimple;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface InboxTemplateApi extends BaseApi<InboxTemplateResponse, InboxTemplateSimple, InboxTemplateDataRequest> {


}
