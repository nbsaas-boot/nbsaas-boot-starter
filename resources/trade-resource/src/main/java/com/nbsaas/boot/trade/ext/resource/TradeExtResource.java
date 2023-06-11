package com.nbsaas.boot.trade.ext.resource;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.trade.api.domain.enums.AccountType;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;
import com.nbsaas.boot.trade.data.entity.TradeAccount;
import com.nbsaas.boot.trade.data.entity.TradeInfo;
import com.nbsaas.boot.trade.data.entity.TradeStream;
import com.nbsaas.boot.trade.data.repository.TradeAccountRepository;
import com.nbsaas.boot.trade.data.repository.TradeInfoRepository;
import com.nbsaas.boot.trade.data.repository.TradeStreamRepository;
import com.nbsaas.boot.trade.ext.apis.TradeExtApi;
import com.nbsaas.boot.trade.ext.domain.request.TradeRequest;
import com.nbsaas.boot.trade.rest.convert.TradeAccountResponseConvert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;


@Service
public class TradeExtResource implements TradeExtApi {

    @Resource
    private TradeAccountRepository tradeAccountRepository;

    @Resource
    private TradeInfoRepository tradeInfoRepository;

    @Resource
    private TradeStreamRepository tradeStreamRepository;

    @Override
    public TradeAccountResponse initNormal() {
        return init(AccountType.normal);

    }

    @Override
    public TradeAccountResponse initSpecial() {
        return init(AccountType.special);
    }

    private TradeAccountResponse init(AccountType accountType) {
        TradeAccount bean = new TradeAccount();
        bean.setAmount(new BigDecimal(0));
        bean.setAccountType(accountType);
        bean.setSerialNo(0);
        tradeAccountRepository.save(bean);
        return new TradeAccountResponseConvert().convert(bean);
    }

    @Override
    public ResponseObject<TradeInfoResponse> trade(TradeRequest request) {
        ResponseObject<TradeInfoResponse> result = new ResponseObject<TradeInfoResponse>();
        if (request.getAmount() == null || request.getAmount().floatValue() <= 0) {
            result.setMsg("金额不能为负数");
            result.setCode(-303);
            return result;
        }
        if (request.getNote() != null && request.getNote().length() > 30) {
            request.setNote(request.getNote().substring(0, 30));
        }


        TradeAccount fromAccount = tradeAccountRepository.findById(request.getFrom()).get();
        if (fromAccount.getAccountType() == AccountType.normal) {
            if (fromAccount.getAmount().compareTo(request.getAmount()) < 0) {
                result.setMsg("余额不足");
                result.setCode(-301);
                return result;
            }
        }

        TradeAccount toAccount = tradeAccountRepository.findById(request.getTo()).get();

        TradeInfo trade = new TradeInfo();
        trade.setAmount(request.getAmount());
        trade.setTo(toAccount);
        trade.setFrom(fromAccount);
        tradeInfoRepository.save(trade);

       handFrom(request, fromAccount, trade);
       handTo(request, toAccount, trade);
        request.setTo(request.getTo());
        request.setFrom(request.getFrom());
        request.setAmount(request.getAmount());

        return result;
    }


    private Long handTo(TradeRequest request, TradeAccount toAccount, TradeInfo trade) {
        BigDecimal money = request.getAmount();
        BigDecimal before = toAccount.getAmount();
        BigDecimal after = toAccount.getAmount().add(money);
        Integer toIndex = toAccount.getSerialNo();
        if (toIndex == null) {
            toIndex = 0;
        }
        toIndex++;
        toAccount.setAmount(after);
        toAccount.setLastDate(new Date());
        toAccount.setSerialNo(toIndex);

        TradeStream stream = new TradeStream();
        stream.setSerialNo(toIndex);
        stream.setAmount(money);
        stream.setAccount(toAccount);
        stream.setNote(request.getNote());
        stream.setPreAmount(before);
        stream.setAfterAmount(after);
        stream.setChangeType(request.getChangeType());
        stream.setInfo(trade);
        tradeStreamRepository.save(stream);
        return stream.getId();
    }

    private Long handFrom(TradeRequest request, TradeAccount fromAccount, TradeInfo trade) {
        BigDecimal money = request.getAmount();
        BigDecimal before = fromAccount.getAmount();
        BigDecimal after = fromAccount.getAmount().subtract(money);
        Integer fromIndex = fromAccount.getSerialNo();
        if (fromIndex == null) {
            fromIndex = 0;
        }
        fromIndex++;
        fromAccount.setAmount(after);
        fromAccount.setLastDate(new Date());
        fromAccount.setSerialNo(fromIndex);


        TradeStream stream = new TradeStream();
        stream.setSerialNo(fromIndex);
        stream.setAmount(money.multiply(new BigDecimal(-1)));
        stream.setAccount(fromAccount);
        stream.setNote(request.getNote());
        stream.setPreAmount(before);
        stream.setAfterAmount(after);
        stream.setChangeType(request.getChangeType());
        stream.setInfo(trade);
        tradeStreamRepository.save(stream);
        return stream.getId();
    }
}
