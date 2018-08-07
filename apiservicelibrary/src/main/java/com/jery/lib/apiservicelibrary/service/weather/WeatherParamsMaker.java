package com.jery.lib.apiservicelibrary.service.weather;

import com.jery.lib.networklibrary.utils.ParamsUtils;
import com.jery.lib.networklibrary.utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

class WeatherParamsMaker {


    public static HashMap<String, Object> getWeatherParams(@NotNull String format, @NotNull String cityname, @NotNull String key) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("format", format);
        hashMap.put("cityname", cityname);
        hashMap.put("key", key);
        return ParamsUtils.checkedParams(hashMap);
    }


}
