package com.CeciliaInezRevaJSleepRJ.jsleep_android.request;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.Call;
import retrofit2.http.Query;

public interface BaseApiService {
    @GET("account/{id}")
    Call<Account> getAccount (@Path("id") int id);

    @POST("login/{id}")
    Call<Account> login (@Query("email") String email, @Query("password") String password);

    @GET("account/register")
    Call<Account> register (@Query("name") String name, @Query("email") String email, @Query("password") String password);
}
