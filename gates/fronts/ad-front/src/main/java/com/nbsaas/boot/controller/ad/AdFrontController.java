package com.nbsaas.boot.controller.ad;

import com.nbsaas.boot.ad.api.apis.AdApi;
import com.nbsaas.boot.ad.api.domain.request.AdSearchRequest;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 前端控制器
 */
@RestController
@RequestMapping("/ad")
public class AdFrontController {


    @Resource
    private AdApi adApi;


    @RequestMapping("/search")
    public PageResponse<AdSimple> search(AdSearchRequest request) {
        return adApi.search(request);
    }

    @RequestMapping("/list")
    public ListResponse<AdSimple> list(AdSearchRequest request) {
        return adApi.list(request);
    }

}
