package com.CeciliaInezRevaJSleepRJ.jsleep_android.request;

public class UtilsApi {
    public static final String BASE_URL_API = "http://10.10.62.165:8080/";

    public static BaseApiService getApiService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
