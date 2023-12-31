package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserAccount;
import com.nbsaas.boot.user.api.domain.response.UserAccountResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
* 实体对象转化成响应对象
*/

public class UserAccountResponseConvert  implements Converter<UserAccountResponse,UserAccount> {

    @Override
    public UserAccountResponse convert(UserAccount source) {
        UserAccountResponse  result = new  UserAccountResponse();
        BeanDataUtils.copyProperties(source, result);
                    if(source.getAccountType()!=null){
                        result.setAccountTypeName(String.valueOf(source.getAccountType()));
                    }
                    if(source.getUser()!=null){
                        result.setUser(source.getUser().getId());
                    }
        return result;
    }

}

