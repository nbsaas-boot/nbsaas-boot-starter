package com.nbsaas.boot.message.api.apis;

import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;
import com.nbsaas.boot.message.api.domain.simple.InboxMessageSimple;
import com.nbsaas.boot.message.api.domain.response.InboxMessageResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface InboxMessageApi extends BaseApi<InboxMessageResponse, InboxMessageSimple, InboxMessageDataRequest> {


}
