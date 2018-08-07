package com.jery.lib.apiservicelibrary.service.weather;

import com.jery.lib.networklibrary.callback.RequestCallBack;
import com.jery.lib.networklibrary.service.ServiceExecutor;
import com.jery.lib.networklibrary.service.ServiceGenerator;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class WeatherServiceImpl {

    private static WeatherServiceImpl instance;

    private WeatherServiceImpl() {
    }

    public static WeatherServiceImpl getInstance() {
        if (instance == null) {
            synchronized (WeatherServiceImpl.class) {
                if (instance == null)
                    instance = new WeatherServiceImpl();
            }
        }
        return instance;
    }

    public void getWeatherInfo(@NotNull String format, @NotNull String cityname, @NotNull String key, RequestCallBack callBack) {
        WeatherService userService = ServiceGenerator.createService(WeatherService.class);
        HashMap<String, Object> params = WeatherParamsMaker.getWeatherParams(format, cityname, key);
        ServiceExecutor.getInstance().execute(userService.getWeatherInfo(params), callBack);

    }
}
