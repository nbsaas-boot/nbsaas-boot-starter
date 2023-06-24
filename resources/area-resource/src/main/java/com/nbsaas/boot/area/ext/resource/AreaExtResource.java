package com.nbsaas.boot.area.ext.resource;

import com.haoxuer.lbs.qq.v1.builder.ServicesBuilder;
import com.haoxuer.lbs.qq.v1.domain.response.Geo;
import com.haoxuer.lbs.qq.v1.service.GeoCoderService;
import com.nbsaas.boot.area.api.apis.AreaApi;
import com.nbsaas.boot.area.api.domain.response.AreaResponse;
import com.nbsaas.boot.area.ext.apis.AreaExtApi;
import com.nbsaas.boot.area.ext.domain.request.PoiSearchRequest;
import com.nbsaas.boot.area.ext.domain.response.PoiResponse;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AreaExtResource implements AreaExtApi {

    @Resource
    private AreaApi areaApi;


    private String clearProvince(String province) {
        String result = "";
        if (province != null) {
            result = province.replace("省", "");
            result = result.replace("市", "");
            return result;
        }
        return result;
    }

    private String clearCity(String province) {
        String result = "";
        if (province != null) {
            result = province.replace("省", "");
            result = result.replace("市", "");
            result = result.replace("区", "");
            result = result.replace("县", "");
            if ("重庆".equals(result)) {
                return result + "城区";
            } else if ("北京".equals(result)) {
                return result + "城区";
            } else if ("上海".equals(result)) {
                return result + "城区";
            } else if ("天津".equals(result)) {
                return result + "城区";
            } else {
                return result;
            }

        }

        return result;
    }

    private String clearCounty(String province) {
        String result = "";
        if (province != null) {
            result = province.replace("省", "");
            result = result.replace("市", "");
            result = result.replace("区", "");
            result = result.replace("县", "");
            return result;
        }
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseObject<PoiResponse> lbs(PoiSearchRequest request) {
        ResponseObject<PoiResponse> result = new ResponseObject<>();
        PoiResponse data = new PoiResponse();
        result.setData(data);
        try {
            GeoCoderService service = ServicesBuilder.newBuilder().key("H4DBZ-WLVCU-YLEVF-4MIDF-MGB5H-TOFDR").build().geoGeoCoderService();

            Geo geo = service.address(request.getAddress());
            if (geo != null && geo.getLocation() != null) {
                data.setLat(Double.valueOf(geo.getLocation().getLat()));
                data.setLng(Double.valueOf(geo.getLocation().getLng()));
            }
            if (geo != null) {
                data.setAddress(geo.getTitle());
                data.setProvince(geo.getProvince());
                data.setCity(geo.getCity());
                data.setCounty(geo.getDistrict());
                AreaResponse area = areaApi.oneData(Filter.eq("name", clearProvince(geo.getProvince())));
                if (area != null) {
                    data.setProvinceId(area.getId());
                }
                AreaResponse city = areaApi.oneData(Filter.eq("name", clearCity(geo.getCity())), Filter.eq("depth", 3));
                if (city != null) {
                    data.setCityId(city.getId());
                }
                AreaResponse county = null;
                if (city != null) {
                    county = areaApi.oneData(Filter.eq("parent.id", city.getId()),
                            Filter.eq("name", geo.getDistrict()));
                } else {
                    county = areaApi.oneData(Filter.eq("name", geo.getDistrict()));
                }
                if (county != null) {
                    data.setCountyId(county.getId());
                }
            }
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg(e.getMessage());
        }


        return result;
    }
}
