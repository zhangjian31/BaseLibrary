package com.jery.lib.networklibrary.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jery.config.JeryConfig;
import com.jery.lib.networklibrary.adapter.DoubleTypeAdapter;
import com.jery.lib.networklibrary.adapter.FloatTypeAdapter;
import com.jery.lib.networklibrary.adapter.IntegerTypeAdapter;
import com.jery.lib.networklibrary.adapter.LongTypeAdapter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Utils {


    private static OkHttpClient mOkHttpClient;
    private static Retrofit.Builder builder;

    public static OkHttpClient getOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (Utils.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
//                            .addInterceptor(new HeaderInterceptor())
//                            .addInterceptor(new EncryptInterceptor())
//                            .addInterceptor(new LoggerInterceptor())
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    public static Retrofit.Builder getRetrofitBuilder() {
        if (builder == null) {
            synchronized (Utils.class) {
                if (builder == null) {
                    Gson gson = new GsonBuilder()
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(int.class, Integer.class, new IntegerTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(long.class, Long.class, new LongTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(float.class, Float.class, new FloatTypeAdapter()))
                            .registerTypeAdapterFactory(TypeAdapters.newFactory(double.class, Double.class, new DoubleTypeAdapter()))
                            .create();

                    builder = new Retrofit.Builder()
                            .client(getOkHttpClient())
                            .baseUrl(JeryConfig.baseUrl)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson));
                }
            }
        }
        return builder;
    }


}
