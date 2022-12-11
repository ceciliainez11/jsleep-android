package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {
    BaseApiService mApiService;
    EditText username, email, password;
    Context mContext;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mApiService = UtilsApi.getApiService();
        mContext = this;

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        Button register = findViewById(R.id.buttonRegisterPage);
        username = findViewById(R.id.nameRegister);
        password = findViewById(R.id.passwordRegister);
        email = findViewById(R.id.emailRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailT = email.getText().toString();
                String passwordT = password.getText().toString();
                String nameT = username.getText().toString();
                Account account = requestRegister(emailT, passwordT, nameT);
            }
        });
    }

    protected Account requestRegister(String email, String password, String name ){
        System.out.println("tEST1");
        mApiService.register(name, email, password).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if(response.isSuccessful()){
                    Account account;
                    account = response.body();
                    System.out.println(account.toString());
                    Intent move = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(move);
                    System.out.println("tEST2");
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(mContext, "Account Already Registered", Toast.LENGTH_SHORT).show();
                System.out.println("tEST3");
            }
        });
        return null;
    }


}