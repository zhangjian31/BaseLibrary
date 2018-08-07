package com.jery.lib.apiservicelibrary.service.login;

import com.jery.lib.networklibrary.utils.ParamsUtils;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

class LoginParamsMaker {


    public static HashMap<String, Object> getLoginParams(@NotNull String userName,@NotNull String passwd) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", userName);
        hashMap.put("passwd", passwd);
        return ParamsUtils.checkedParams(hashMap);
    }


}
