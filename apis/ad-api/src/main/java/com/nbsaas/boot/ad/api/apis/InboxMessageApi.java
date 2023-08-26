package com.nbsaas.boot.ad.api.apis;

import com.nbsaas.boot.ad.api.domain.request.InboxMessageDataRequest;
import com.nbsaas.boot.ad.api.domain.simple.InboxMessageSimple;
import com.nbsaas.boot.ad.api.domain.response.InboxMessageResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface InboxMessageApi extends BaseApi<InboxMessageResponse, InboxMessageSimple, InboxMessageDataRequest> {


}
