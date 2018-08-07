package com.jery.lib.apiservicelibrary.service.data;


import com.jery.lib.apiservicelibrary.entity.input.InputDataResult;
import com.jery.lib.apiservicelibrary.entity.weather.WeatherResult;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


interface InputDataService {

    @GET("/test/api/printInputData.php")
    Observable<InputDataResult> getInputDataInfo(@QueryMap HashMap<String, Object> params);

}
