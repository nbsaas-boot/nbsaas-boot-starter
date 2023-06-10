package com.nbsaas.boot.system.ext.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.system.api.domain.request.DictItemSearchRequest;
import lombok.Data;

@Data
public class DictItemSearchExtRequest extends DictItemSearchRequest {

    @Search(name = "dict.id", operator = Operator.eq)
    private Long dict;

    @Search(name = "dict.dictKey", operator = Operator.eq)
    private String dictKey;
}
