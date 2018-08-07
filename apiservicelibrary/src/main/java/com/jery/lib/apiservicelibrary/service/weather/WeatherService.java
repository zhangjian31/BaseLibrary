package com.jery.lib.apiservicelibrary.service.weather;


import com.jery.lib.apiservicelibrary.entity.weather.WeatherResult;
import com.jery.lib.networklibrary.model.BaseResult;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


interface WeatherService {

    @GET("/test/api/getWeaterInfo.php")
    Observable<WeatherResult> getWeatherInfo(@QueryMap HashMap<String, Object> params);

}
