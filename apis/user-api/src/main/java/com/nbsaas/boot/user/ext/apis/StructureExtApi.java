package com.nbsaas.boot.user.ext.apis;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;

public interface StructureExtApi {

    ListResponse<StructureSimple> listByStruct(Long structureId);


    ListResponse<StructureSimple> treeByStruct(Long structureId);

}
