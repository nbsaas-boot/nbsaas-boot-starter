package com.nbsaas.boot.user.ext.domain.request;

import com.nbsaas.boot.rest.filter.Operator;
import com.nbsaas.boot.rest.filter.Search;
import com.nbsaas.boot.user.api.domain.request.StructureSearchRequest;
import lombok.Data;


@Data
public class StructureSearchExtRequest extends StructureSearchRequest {


    @Search(name = "ids",operator = Operator.likePrefix)
    private String treeId;
}
