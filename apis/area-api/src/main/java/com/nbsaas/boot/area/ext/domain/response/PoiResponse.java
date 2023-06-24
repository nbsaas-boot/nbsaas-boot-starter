package com.nbsaas.boot.area.ext.domain.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class PoiResponse implements Serializable {

    private String address;

    private String city;

    private String province;

    private String county;

    private Long cityId;

    private Long provinceId;

    private Long countyId;

    private Double lng;
    private Double lat;
}
