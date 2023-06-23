package com.nbsaas.boot.security.realm;

import com.nbsaas.boot.security.api.AuthorizationApi;
import com.nbsaas.boot.security.token.DataToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class DataRealm<T> extends AuthorizingRealm {

    @Resource
    private AuthorizationApi authorizationApi;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (authorizationApi!=null){
            info.addRoles(authorizationApi.loadRoles());
            info.addStringPermissions(authorizationApi.loadPermissions());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        DataToken<T> token = (DataToken<T>) authenticationToken;
        return new SimpleAuthenticationInfo(token.getData(), token.getPassword(), getName());
    }
}
