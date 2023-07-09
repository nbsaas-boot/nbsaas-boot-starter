package com.nbsaas.boot.pay.ext.resource;

import com.nbsaas.boot.pay.api.apis.CashConfigApi;
import com.nbsaas.boot.pay.api.apis.PayUserApi;
import com.nbsaas.boot.pay.api.domain.request.PayUserDataRequest;
import com.nbsaas.boot.pay.api.domain.response.CashConfigResponse;
import com.nbsaas.boot.pay.api.domain.response.PayUserResponse;
import com.nbsaas.boot.pay.ext.apis.CashConfigExtApi;
import com.nbsaas.boot.pay.ext.domain.response.CashConfigExtResponse;
import com.nbsaas.boot.pay.ext.domain.response.CashConfigExtSearchRequest;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.trade.ext.apis.TradeExtApi;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Service
public class CashConfigExtResource implements CashConfigExtApi {

    @Resource
    private CashConfigApi cashConfigApi;

    @Resource
    private PayUserApi payUserApi;

    @Resource
    private TradeExtApi tradeExtApi;


    @Transactional
    @Override
    public ResponseObject<CashConfigExtResponse> config(CashConfigExtSearchRequest request) {
        ResponseObject<CashConfigExtResponse> result = new ResponseObject<>();

        CashConfigResponse bean = cashConfigApi.oneData(
                Filter.eq("key", request.getKey()));
        if (bean == null) {
            result.setCode(1000);
            result.setMsg("无效id");
            return result;
        }
        PayUserResponse staff = payUserApi.oneData(Filter.eq("id", request.getUser()));
        if (staff == null) {
            result.setCode(1001);
            result.setMsg("无效用户");
            return result;
        }
        if (staff.getTradeAccount() == null) {
            staff.setTradeAccount(tradeExtApi.initNormal().getId());

            PayUserDataRequest staffForm = new PayUserDataRequest();
            staffForm.setId(staff.getId());
            staffForm.setTradeAccount(staffForm.getTradeAccount());
            payUserApi.update(staffForm);
        }
        CashConfigExtResponse data = new CashConfigExtResponse();
        BeanUtils.copyProperties(bean, data);
        data.setAmount(staff.getTradeAccountAmount());
        if (data.getAmount() == null) {
            data.setAmount(BigDecimal.ZERO);
        }

        result.setData(data);
        return result;
    }
}
