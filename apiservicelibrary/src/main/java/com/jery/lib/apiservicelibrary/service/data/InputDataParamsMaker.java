package com.jery.lib.apiservicelibrary.service.data;

import com.jery.lib.networklibrary.utils.ParamsUtils;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

class InputDataParamsMaker {


    public static HashMap<String, Object> getInputDataParams(@NotNull String user) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user", user);
        return ParamsUtils.checkedParams(hashMap);
    }


}
