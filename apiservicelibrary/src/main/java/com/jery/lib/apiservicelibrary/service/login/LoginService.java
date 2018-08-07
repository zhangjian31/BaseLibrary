package com.jery.lib.apiservicelibrary.service.login;


import com.jery.lib.apiservicelibrary.entity.login.LoginResult;
import java.util.HashMap;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


interface LoginService {
    @FormUrlEncoded
    @POST("/test/api/login.php")
    Observable<LoginResult> getLoginInfo(@FieldMap HashMap<String, Object> params);

}
