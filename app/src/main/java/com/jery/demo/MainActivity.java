package com.jery.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.jery.lib.apiservicelibrary.entity.weather.WeatherResult;
import com.jery.lib.apiservicelibrary.service.weather.WeatherServiceImpl;
import com.jery.lib.baselibrary.R;
import com.jery.lib.networklibrary.callback.RequestCallBack;
import com.jery.lib.networklibrary.model.BaseResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.getBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

    }

    public void getData() {
        WeatherServiceImpl.getInstance().getWeatherInfo("2", "北京", "41bcf09ab9a376819b6c093b97f95c82", new RequestCallBack("") {
            @Override
            public void onNext(BaseResult baseResult) {
                super.onNext(baseResult);
                if (baseResult != null) {
                    if (baseResult.getCode() == 200) {
                        WeatherResult weatherResult = (WeatherResult) baseResult;
                        Log.e("WeatherResult=",weatherResult.toString());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}
