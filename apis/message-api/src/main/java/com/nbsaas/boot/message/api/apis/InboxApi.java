package com.nbsaas.boot.message.api.apis;

import com.nbsaas.boot.message.api.domain.request.InboxDataRequest;
import com.nbsaas.boot.message.api.domain.simple.InboxSimple;
import com.nbsaas.boot.message.api.domain.response.InboxResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface InboxApi extends BaseApi<InboxResponse, InboxSimple, InboxDataRequest> {


}
