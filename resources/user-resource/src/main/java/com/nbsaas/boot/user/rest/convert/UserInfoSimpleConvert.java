package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class UserInfoSimpleConvert implements Converter<UserInfoSimple, UserInfo> {




@Override
public UserInfoSimple convert(UserInfo source) {
    UserInfoSimple result = new UserInfoSimple();

                result.setNote(source.getNote());
                result.setCatalog(source.getCatalog());
                if(source.getStructure()!=null){
                    result.setStructureName(source.getStructure().getName());
                }
                result.setAvatar(source.getAvatar());
                if(source.getDataScope()!=null){
                    result.setDataScopeName(String.valueOf(source.getDataScope()));
                }
                result.setDataScope(source.getDataScope());
                result.setAddDate(source.getAddDate());
                if(source.getStructure()!=null){
                    result.setStructure(source.getStructure().getId());
                }
                result.setLoginSize(source.getLoginSize());
                result.setPhone(source.getPhone());
                result.setAccountNo(source.getAccountNo());
                result.setName(source.getName());
                if(source.getStoreState()!=null){
                    result.setStoreStateName(String.valueOf(source.getStoreState()));
                }
                result.setStoreState(source.getStoreState());
                if(source.getState()!=null){
                    result.setStateName(String.valueOf(source.getState()));
                }
                result.setState(source.getState());
                result.setId(source.getId());
                result.setLastDate(source.getLastDate());


    return result;
}

}