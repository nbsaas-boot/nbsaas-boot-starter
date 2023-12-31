package com.nbsaas.boot.user.ext.resource;

import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.request.LongId;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.user.api.apis.*;
import com.nbsaas.boot.user.api.domain.enums.AccountType;
import com.nbsaas.boot.user.api.domain.enums.SecurityType;
import com.nbsaas.boot.user.api.domain.field.UserAccountField;
import com.nbsaas.boot.user.api.domain.field.UserOauthConfigField;
import com.nbsaas.boot.user.api.domain.field.UserPasswordField;
import com.nbsaas.boot.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.boot.user.api.domain.response.*;
import com.nbsaas.boot.user.data.entity.UserInfo;
import com.nbsaas.boot.user.ext.apis.PasswordApi;
import com.nbsaas.boot.user.ext.apis.UserExtApi;
import com.nbsaas.boot.user.ext.domain.request.*;
import com.nbsaas.boot.user.ext.domain.response.PasswordResponse;
import com.nbsaas.boot.user.ext.domain.response.TokenResponse;
import com.nbsaas.boot.user.ext.domain.response.UserInfoExtResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class UserExtResource implements UserExtApi {


    @Resource
    private UserAccountApi userAccountApi;

    @Resource
    private UserPasswordApi userPasswordApi;

    @Resource
    private UserInfoApi userInfoApi;

    @Resource
    private PasswordApi passwordApi;

    @Resource
    private UserOauthConfigApi userOauthConfigApi;

    @Resource
    private UserOauthTokenApi userOauthTokenApi;

    @Resource
    private UserRoleApi userRoleApi;


    @Override
    public ResponseObject<Boolean> checkRegister(UserRegisterRequest request) {
        ResponseObject<Boolean> result = new ResponseObject<>();
        Long num = userAccountApi.countData(Filter.eq(UserAccountField.username, request.getUsername()),
                Filter.eq(UserAccountField.accountType, request.getAccountType()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setData(false);
        } else {
            result.setData(true);
        }
        return result;
    }


    @Transactional
    @Override
    public ResponseObject<UserInfoResponse> register(UserRegisterRequest request) {
        ResponseObject<UserInfoResponse> result = new ResponseObject<>();
        if (request.getAccountType() == null) {
            request.setAccountType(AccountType.account);
        }
        /**
         * 描述：查询user账户是否被备注
         */
        Long num = userAccountApi.countData(Filter.eq(UserAccountField.accountType, request.getAccountType()),
                Filter.eq(UserAccountField.username, request.getUsername()));
        if (num == null) {
            num = 0L;
        }
        if (num > 0) {
            result.setCode(503);
            result.setMsg("该用户名已被使用");
            return result;
        }
        /**
         * 描述：user表写入
         */
        UserInfoDataRequest userForm = new UserInfoDataRequest();
        userForm.setName(request.getUsername());
        userForm.setPhone(request.getUsername());
        userForm.setAccountNo(request.getUsername());
        UserInfoResponse response = userInfoApi.createData(userForm);

        /**
         * 描述：user账户表写入
         */
        UserAccountDataRequest userAccount = new UserAccountDataRequest();
        userAccount.setAccountType(request.getAccountType());
        userAccount.setUsername(request.getUsername());
        userAccount.setLoginSize(0);
        userAccount.setUser(response.getId());
        userAccountApi.createData(userAccount);

        PasswordRequest passwordRequest=new  PasswordRequest();
        passwordRequest.setPassword(request.getPassword());
        PasswordResponse password = passwordApi.password(passwordRequest);

        UserPasswordDataRequest userPassword = new UserPasswordDataRequest();
        userPassword.setSalt(password.getSalt());
        userPassword.setPassword(password.getPassword());
        userPassword.setUser(response.getId());
        userPassword.setSecurityType(SecurityType.account);
        userPassword.setAddDate(new Date());
        userPassword.setLastDate(new Date());
        userPassword.setCheckSize(0);
        userPasswordApi.createData(userPassword);

        result.setData(response);
        return result;
    }

    @Transactional
    @Override
    public ResponseObject<?> updatePassword(UserUpdatePasswordRequest request) {
        ResponseObject<?> result = new ResponseObject<>();

        UserInfoResponse user = userInfoApi.oneData(Filter.eq("id", request.getId()));
        if (user == null) {
            result.setCode(501);
            result.setMsg("无效用户");
            return result;
        }
        UserPasswordResponse password = userPasswordApi.oneData(Filter.eq(UserPasswordField.user, request.getId()));
        if (password == null) {
            result.setCode(502);
            result.setMsg("没有设置密码");
            return result;
        }

        //检查老密码
        PasswordRequest req = new PasswordRequest();
        req.setSalt(password.getSalt());
        req.setPassword(request.getOldPassword());
        PasswordResponse ps = passwordApi.passwordBySalt(req);
        if (!ps.getPassword().equals(password.getPassword())) {
            result.setCode(503);
            result.setMsg("老密码不正确");
            return result;
        }

        PasswordRequest pasReq = new PasswordRequest();
        pasReq.setPassword(request.getPassword());
        PasswordResponse newPassword = passwordApi.password(pasReq);

        //修改密码
        UserPasswordDataRequest passwordDataRequest = new UserPasswordDataRequest();
        passwordDataRequest.setPassword(newPassword.getPassword());
        passwordDataRequest.setSalt(newPassword.getSalt());
        passwordDataRequest.setId(password.getId());
        userPasswordApi.update(passwordDataRequest);

        return result;
    }

    @Transactional
    @Override
    public ResponseObject<?> resetPassword(UserResetPasswordRequest request) {
        ResponseObject<?> result = new ResponseObject<>();

        UserInfoResponse user = userInfoApi.oneData(Filter.eq("id", request.getId()));
        if (user == null) {
            result.setCode(501);
            result.setMsg("无效用户");
            return result;
        }
        UserPasswordResponse password = userPasswordApi.oneData(Filter.eq(UserPasswordField.user, request.getId()));
        if (password == null) {
            UserPasswordDataRequest req=new UserPasswordDataRequest();
            req.setUser(request.getId());
            req.setSecurityType(SecurityType.account);
            password=userPasswordApi.createData(req);
        }

        PasswordRequest pasReq = new PasswordRequest();
        pasReq.setPassword(request.getPassword());
        PasswordResponse newPassword = passwordApi.password(pasReq);

        //修改密码
        UserPasswordDataRequest passwordDataRequest = new UserPasswordDataRequest();
        passwordDataRequest.setPassword(newPassword.getPassword());
        passwordDataRequest.setSalt(newPassword.getSalt());
        passwordDataRequest.setId(password.getId());
        userPasswordApi.update(passwordDataRequest);

        return result;
    }

    @Transactional
    @Override
    public ResponseObject<UserInfoExtResponse> login(UserLoginRequest request) {
        ResponseObject<UserInfoExtResponse> result = new ResponseObject<>();
        if (request.getAccountType() == null) {
            request.setAccountType(AccountType.phone);
        }
        UserAccountResponse account = userAccountApi.oneData(
                Filter.eq(UserAccountField.username, request.getUsername()),
                Filter.eq(UserAccountField.accountType, request.getAccountType())
        );
        if (account == null) {
            result.setCode(501);
            result.setMsg("账号不存在");
            return result;
        }
        UserInfo info = new UserInfo();
        info.setId(account.getUser());
        UserPasswordResponse password = userPasswordApi.oneData(Filter.eq("user.id", account.getUser()));
        if (password == null) {
            result.setCode(502);
            result.setMsg("密码不存在");
            return result;
        }
        PasswordRequest req = new PasswordRequest();
        req.setPassword(request.getPassword());
        req.setSalt(password.getSalt());
        PasswordResponse pwd = passwordApi.passwordBySalt(req);
        if (!pwd.getPassword().equals(password.getPassword())) {
            result.setCode(503);
            result.setMsg("密码错误");
            return result;
        }
        ResponseObject<UserInfoResponse> res = userInfoApi.view(new LongId(account.getUser()));
        if (res.getCode() != 200) {
            result.setCode(504);
            result.setMsg("没有用户信息");
            return result;
        }

        UserInfoExtResponse extResponse = new UserInfoExtResponse();
        BeanUtils.copyProperties(res.getData(), extResponse);

        result.setData(extResponse);
        return result;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public ResponseObject<UserInfoExtResponse> loginOauth(UserLoginOatuthRequest request) {
        ResponseObject<UserInfoExtResponse> result = new ResponseObject<>();
        UserOauthConfigResponse config = userOauthConfigApi.oneData(Filter.eq(UserOauthConfigField.model, request.getType()));
        if (config == null) {
            result.setCode(501);
            result.setMsg("没有登录配置");
            return result;
        }
        OauthHandler oauthHandler = null;
        try {
            Class c = Class.forName(config.getClassName());
            oauthHandler = (OauthHandler) c.newInstance();
            oauthHandler.setKey(config.getAppKey());
            oauthHandler.setSecret(config.getAppSecret());
        } catch (Exception e) {
            result.setCode(502);
            result.setMsg("加载登录配置失败");
            return result;
        }
        String openId = "";
        TokenResponse response = oauthHandler.getToken(request.getCode());
        if (response != null) {
            openId = response.getOpenId();
        }
        if (!StringUtils.hasText(openId)) {
            result.setCode(503);
            result.setMsg("第三方授权失败");
            return result;
        }
        UserOauthTokenResponse token = userOauthTokenApi.oneData(Filter.eq("userOauthConfig.id", config.getId()),
                Filter.eq("openId", openId));
        if (token == null) {
            UserInfoDataRequest userInfoDataRequest = new UserInfoDataRequest();
            UserInfoResponse res = userInfoApi.createData(userInfoDataRequest);

            UserOauthTokenDataRequest tokenDataRequest = new UserOauthTokenDataRequest();
            tokenDataRequest.setUser(res.getId());
            tokenDataRequest.setUserOauthConfig(config.getId());
            tokenDataRequest.setOpenId(openId);
            tokenDataRequest.setAccessToken(response.getAccessToken());
            tokenDataRequest.setRefreshToken(response.getRefreshToken());
            tokenDataRequest.setUnionId(response.getUnionid());
            userOauthTokenApi.createData(tokenDataRequest);

            UserInfoExtResponse ext = new UserInfoExtResponse();
            BeanUtils.copyProperties(res, ext);
            ext.setOpenId(openId);
            result.setData(ext);
            return result;
        }

        UserInfoResponse user = userInfoApi.oneData(Filter.eq("id", token.getUser()));
        UserInfoExtResponse ext = new UserInfoExtResponse();
        BeanUtils.copyProperties(user, ext);
        ext.setOpenId(openId);
        result.setData(ext);

        return result;
    }

    @Transactional
    @Override
    public ResponseObject<String> findOpenId(UserLoginOatuthRequest request) {
        ResponseObject<String> result = new ResponseObject<>();
        UserOauthConfigResponse config = userOauthConfigApi.oneData(Filter.eq(UserOauthConfigField.model, request.getType()));
        if (config == null) {
            result.setCode(501);
            result.setMsg("没有登录配置");
            return result;
        }
        OauthHandler oauthHandler = null;
        try {
            Class c = Class.forName(config.getClassName());
            oauthHandler = (OauthHandler) c.newInstance();
            oauthHandler.setKey(config.getAppKey());
            oauthHandler.setSecret(config.getAppSecret());
        } catch (Exception e) {
            result.setCode(502);
            result.setMsg("加载登录配置失败");
            return result;
        }
        String openId = "";
        TokenResponse response = oauthHandler.getToken(request.getCode());
        if (response != null) {
            openId = response.getOpenId();
        }
        if (!StringUtils.hasText(openId)) {
            result.setCode(503);
            result.setMsg("第三方授权失败");
            return result;
        }
        result.setData(openId);
        return result;
    }

    @Override
    public ListResponse<String> selectPermissionByUser(Long userId) {
        ListResponse<String> result = new ListResponse<>();
        userRoleApi.listData(Filter.eq("", userId));

        return null;
    }
}
