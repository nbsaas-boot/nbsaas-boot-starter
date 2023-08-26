package com.nbsaas.boot.message.api.apis;

import com.nbsaas.boot.message.api.domain.request.InboxTemplateNotifyDataRequest;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateNotifySimple;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateNotifyResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface InboxTemplateNotifyApi extends BaseApi<InboxTemplateNotifyResponse, InboxTemplateNotifySimple, InboxTemplateNotifyDataRequest> {


}
