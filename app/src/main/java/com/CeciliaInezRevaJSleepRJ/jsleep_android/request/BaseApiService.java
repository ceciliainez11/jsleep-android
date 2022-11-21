package com.CeciliaInezRevaJSleepRJ.jsleep_android.request;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

public interface BaseApiService {
    @GET("account/{id}")
    Call<Account> getAccount (@Path("id") int id);
}
