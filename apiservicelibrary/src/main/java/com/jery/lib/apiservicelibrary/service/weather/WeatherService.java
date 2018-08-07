package com.jery.lib.apiservicelibrary.service.weather;


import com.jery.lib.apiservicelibrary.entity.weather.WeatherResult;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


interface WeatherService {

    @GET("/weather/index")
    Observable<WeatherResult> getWeatherInfo(@QueryMap HashMap<String, Object> params);

}
