package com.nbsaas.boot.user.ext.resource;

import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.user.api.apis.StructureApi;
import com.nbsaas.boot.user.api.domain.response.StructureResponse;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;
import com.nbsaas.boot.user.ext.apis.StructureExtApi;
import com.nbsaas.boot.user.ext.domain.request.StructureSearchExtRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StructureExtResource implements StructureExtApi {

    @Resource
    private StructureApi structureApi;

    @Transactional
    @Override
    public ListResponse<StructureSimple> listByStruct(Long structureId) {
        ListResponse<StructureSimple> result = new ListResponse<>();
        StructureResponse cur = structureApi.viewById(structureId);
        if (cur == null) {
            result.setCode(501);
            result.setMsg("无效id");
            return result;
        }
        String key = cur.getIds();

        StructureSearchExtRequest request = new StructureSearchExtRequest();
        request.setTreeId(key);

        return structureApi.list(request);
    }


    @Transactional
    @Override
    public ListResponse<StructureSimple> treeByStruct(Long structureId) {
        StructureSearchExtRequest request = new StructureSearchExtRequest();
        request.setParent(structureId);
        request.setFetch(1);
        return structureApi.list(request);
    }
}
