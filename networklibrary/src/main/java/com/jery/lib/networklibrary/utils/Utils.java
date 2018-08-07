package com.jery.lib.networklibrary.utils;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.TypeAdapters;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jery.lib.networklibrary.adapter.DoubleTypeAdapter;
import com.jery.lib.networklibrary.adapter.FloatTypeAdapter;
import com.jery.lib.networklibrary.adapter.IntegerTypeAdapter;
import com.jery.lib.networklibrary.adapter.LongTypeAdapter;

import java.util.HashMap;
import java.util.Map;
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
                            .baseUrl("http://v.juhe.cn:80")
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson));
                }
            }
        }
        return builder;
    }


    public static void initData(Context context) {
//        initDeviceId(context);
    }

    public static boolean hasValue(Object data) {
        if (data instanceof String)
            return !(TextUtils.isEmpty((String) data) || data.equals("null"));
        else
            return false;
    }

    public static HashMap<String, Object> checkedParams(HashMap<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() instanceof String) {
                if (hasValue(entry.getValue()))
                    result.put(entry.getKey(), entry.getValue());
            } else if (entry.getValue() != null) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }


}
