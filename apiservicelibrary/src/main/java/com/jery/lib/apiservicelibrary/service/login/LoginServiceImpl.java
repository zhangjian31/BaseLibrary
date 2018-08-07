package com.jery.lib.apiservicelibrary.service.login;

import com.jery.lib.networklibrary.callback.RequestCallBack;
import com.jery.lib.networklibrary.service.ServiceExecutor;
import com.jery.lib.networklibrary.service.ServiceGenerator;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class LoginServiceImpl {

    private static LoginServiceImpl instance;

    private LoginServiceImpl() {
    }

    public static LoginServiceImpl getInstance() {
        if (instance == null) {
            synchronized (LoginServiceImpl.class) {
                if (instance == null)
                    instance = new LoginServiceImpl();
            }
        }
        return instance;
    }

    public void getLoginInfo(@NotNull String userName,@NotNull String passwd, RequestCallBack callBack) {
        LoginService loginService = ServiceGenerator.createService(LoginService.class);
        HashMap<String, Object> params = LoginParamsMaker.getLoginParams(userName,passwd);
        ServiceExecutor.getInstance().execute(loginService.getLoginInfo(params), callBack);

    }
}
