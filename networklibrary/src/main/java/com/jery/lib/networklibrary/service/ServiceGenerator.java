package com.jery.lib.networklibrary.service;

import com.jery.lib.networklibrary.utils.Utils;

import retrofit2.Retrofit;


public class ServiceGenerator {

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = Utils.getRetrofitBuilder().build();
        return retrofit.create(serviceClass);
    }

}
