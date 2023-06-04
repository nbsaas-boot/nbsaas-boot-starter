package com.nbsaas.boot.controller.ad;

import com.nbsaas.boot.ad.api.apis.AdPositionApi;
import com.nbsaas.boot.ad.api.domain.request.AdPositionSearchRequest;
import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
*  前端控制器
*/
@RestController
@RequestMapping("/adPosition")
public class AdPositionFrontController {


    @Resource
    private AdPositionApi adPositionApi;


    @RequestMapping("/search")
   public PageResponse<AdPositionSimple> search(AdPositionSearchRequest request) {
        return adPositionApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse <AdPositionSimple> list(AdPositionSearchRequest request) {
        return adPositionApi.list(request);
    }

}
