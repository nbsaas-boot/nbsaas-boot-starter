package com.nbsaas.boot.message.ext.resource;

import com.nbsaas.boot.message.api.apis.InboxApi;
import com.nbsaas.boot.message.api.apis.InboxMessageApi;
import com.nbsaas.boot.message.api.apis.InboxTemplateApi;
import com.nbsaas.boot.message.api.apis.InboxTemplateNotifyApi;
import com.nbsaas.boot.message.api.domain.field.InboxField;
import com.nbsaas.boot.message.api.domain.field.InboxMessageField;
import com.nbsaas.boot.message.api.domain.field.InboxTemplateField;
import com.nbsaas.boot.message.api.domain.field.InboxTemplateNotifyField;
import com.nbsaas.boot.message.api.domain.request.InboxDataRequest;
import com.nbsaas.boot.message.api.domain.request.InboxMessageDataRequest;
import com.nbsaas.boot.message.api.domain.response.InboxMessageResponse;
import com.nbsaas.boot.message.api.domain.response.InboxResponse;
import com.nbsaas.boot.message.api.domain.response.InboxTemplateResponse;
import com.nbsaas.boot.message.api.domain.simple.InboxTemplateNotifySimple;
import com.nbsaas.boot.message.ext.apis.InboxMessageExtApi;
import com.nbsaas.boot.message.ext.domain.request.InboxMessageSendRequest;
import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.response.ResponseObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class InboxMessageExtResource implements InboxMessageExtApi {

    @Resource
    private InboxApi inboxApi;

    @Resource
    private InboxTemplateApi inboxTemplateApi;

    @Resource
    private InboxMessageApi inboxMessageApi;

    @Resource
    private InboxTemplateNotifyApi inboxTemplateNotifyApi;


    @Transactional
    @Override
    public ResponseObject<InboxMessageResponse> sendMessage(InboxMessageSendRequest request) {
        ResponseObject<InboxMessageResponse> result=new ResponseObject<>();


        if (request.getToUser() == null) {
            result.setCode(501);
            result.setMsg("没有接收用户");
            return result;
        }
        InboxResponse inbox = inboxApi.oneData(
                Filter.eq(InboxField.dataKey, request.getKey()),
                Filter.eq(InboxField.userId, request.getToUser())
        );
        if (inbox == null) {
            InboxTemplateResponse inboxTemplate = inboxTemplateApi.oneData(Filter.eq(InboxTemplateField.dataKey, request.getKey()));
            if (inboxTemplate == null) {
                result.setCode(501);
                result.setMsg("无效配置信息");
                return result;
            }
            InboxDataRequest inboxForm = new InboxDataRequest();
            inboxForm.setUserId(request.getToUser());
            inboxForm.setId(null);
            inboxForm.setTotalNum(0L);
            inboxForm.setUnReadNum(0L);
            inboxForm.setInboxTemplate(inboxTemplate.getId());
            inboxForm.setName(inboxTemplate.getName());
            inboxForm.setIcon(inboxTemplate.getIcon());
            inboxForm.setDataKey(request.getKey());
            inbox = inboxApi.createData(inboxForm);
        }
        if (inbox == null) {
            result.setCode(502);
            result.setMsg("无效收件箱信息");
            return result;
        }
        InboxMessageDataRequest form = new InboxMessageDataRequest();
        BeanUtils.copyProperties(request, form);
        form.setInbox(inbox.getId());
        form.setState(1);
        inboxMessageApi.createData(form);

        List<InboxTemplateNotifySimple> notifies = inboxTemplateNotifyApi.listData(
                Filter.eq(InboxTemplateNotifyField.inboxTemplate, inbox.getInboxTemplate())
        );
        if (notifies != null && notifies.size() > 0) {
            for (InboxTemplateNotifySimple notify : notifies) {
                System.out.println(notify);
            }
        }

        Long total = inboxMessageApi.countData(
                Filter.eq(InboxMessageField.inbox, inbox.getId())

        );
        inbox.setTotalNum(total);

        Long unReadNum = inboxMessageApi.countData(
                Filter.eq(InboxMessageField.inbox, inbox.getId())
                , Filter.eq(InboxMessageField.state, 1)
        );
        inbox.setUnReadNum(unReadNum);

        InboxDataRequest inboxForm = new InboxDataRequest();
        BeanUtils.copyProperties(inbox, inboxForm);
        inboxApi.update(inboxForm);
        return result;
    }

    @Override
    public ResponseObject<?> read(InboxMessageDataRequest request) {

        ResponseObject<?> result = inboxMessageApi.view(request);
        if (result.getCode() != 200) {
            return result;
        }
        InboxMessageDataRequest form = new InboxMessageDataRequest();
        form.setId(request.getId());
        form.setState(2);
        inboxMessageApi.update(form);
        return result;
    }
}
