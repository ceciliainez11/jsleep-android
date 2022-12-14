package com.CeciliaInezRevaJSleepRJ.jsleep_android.request;

public class UtilsApi {
<<<<<<< HEAD
    public static final String BASE_URL_API = "http://192.168.1.145:8080/";
=======
    public static final String BASE_URL_API = "http://10.0.2.2:8080/";
>>>>>>> 360a270 (Update Proyek Reva - UI)

    public static BaseApiService getApiService() {
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
