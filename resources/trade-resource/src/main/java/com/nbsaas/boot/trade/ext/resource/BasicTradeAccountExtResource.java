package com.nbsaas.boot.trade.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.trade.api.apis.BasicTradeAccountApi;
import com.nbsaas.boot.trade.api.apis.TradeAccountApi;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.BasicTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.ext.apis.BasicTradeAccountExtApi;
import com.nbsaas.boot.trade.ext.apis.TradeExtApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BasicTradeAccountExtResource implements BasicTradeAccountExtApi {

    @Resource
    private BasicTradeAccountApi basicTradeAccountApi;

    @Resource
    private TradeAccountApi tradeAccountApi;

    @Resource
    private TradeExtApi tradeExtApi;

    @Override
    public TradeAccountResponse initNormal(String key) {

        BasicTradeAccountResponse account = basicTradeAccountApi.oneData(Filter.eq("key", key));
        if (account != null) {
            return tradeAccountApi.oneData(Filter.eq("id", account.getAccount()));
        }
        TradeAccountResponse temp = tradeExtApi.initNormal();

        BasicTradeAccountDataRequest req = new BasicTradeAccountDataRequest();
        req.setKey(key);
        req.setAccount(temp.getId());
        basicTradeAccountApi.createData(req);

        return temp;
    }

    @Override
    public TradeAccountResponse initSpecial(String key) {
        BasicTradeAccountResponse account = basicTradeAccountApi.oneData(Filter.eq("key", key));
        if (account != null) {
            return tradeAccountApi.oneData(Filter.eq("id", account.getAccount()));
        }
        TradeAccountResponse temp = tradeExtApi.initSpecial();

        BasicTradeAccountDataRequest req = new BasicTradeAccountDataRequest();
        req.setKey(key);
        req.setAccount(temp.getId());
        basicTradeAccountApi.createData(req);

        return temp;
    }
}
