package com.jery.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jery.lib.apiservicelibrary.entity.input.InputDataResult;
import com.jery.lib.apiservicelibrary.entity.login.LoginResult;
import com.jery.lib.apiservicelibrary.entity.weather.WeatherResult;
import com.jery.lib.apiservicelibrary.service.data.InputDataServiceImpl;
import com.jery.lib.apiservicelibrary.service.login.LoginServiceImpl;
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
//                getData();
//                getInputData();
                getLoginData();
            }
        });

    }

    public void getData() {
        WeatherServiceImpl.getInstance().getWeatherInfo(new RequestCallBack("") {
            @Override
            public void onNext(BaseResult baseResult) {
                super.onNext(baseResult);
                if (baseResult != null) {
                    if (baseResult.getCode() == 200) {
                        WeatherResult weatherResult = (WeatherResult) baseResult;
                        Log.e("WeatherResult=", weatherResult.toString());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }

    public void getInputData() {
        InputDataServiceImpl.getInstance().getInputData("a", new RequestCallBack("") {
            @Override
            public void onNext(BaseResult baseResult) {
                super.onNext(baseResult);
                if (baseResult != null) {
                    if (baseResult.getCode() == 200) {
                        InputDataResult inputDataResult = (InputDataResult) baseResult;
                        Log.e("InputDataResult=", inputDataResult.toString());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }

    public void getLoginData() {
        LoginServiceImpl.getInstance().getLoginInfo("user_a", "paswd_a", new RequestCallBack("") {
            @Override
            public void onNext(BaseResult baseResult) {
                super.onNext(baseResult);
                if (baseResult != null) {
                    if (baseResult.getCode() == 200) {
                        LoginResult loginResult = (LoginResult) baseResult;
                        Log.e("LoginResult=", loginResult.toString());
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
