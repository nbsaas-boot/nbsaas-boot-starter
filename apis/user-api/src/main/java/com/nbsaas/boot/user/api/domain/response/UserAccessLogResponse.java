package com.nbsaas.boot.user.api.domain.response;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserAccessLogResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private Long id;

    private StoreState storeState;

    private String url;

    private String ip;

    private Long creator;

    private String creatorName;

    private Long consumeTime;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;


}