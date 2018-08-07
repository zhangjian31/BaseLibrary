package com.jery.lib.apiservicelibrary.service.weather;

import com.jery.lib.networklibrary.utils.ParamsUtils;
import com.jery.lib.networklibrary.utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

class WeatherParamsMaker {


    public static HashMap<String, Object> getWeatherParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        return ParamsUtils.checkedParams(hashMap);
    }


}
