package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Renter;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutMeActivity extends AppCompatActivity {
    BaseApiService mApiService;
    Context mContext;
    EditText nameInput, addressInput, phoneNumberInput;
    CardView registerCardView,dataCardView;
//    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        Account sessionAccount = MainActivity.loginacc;
        TextView nameAccount = findViewById(R.id.about_name);
        TextView emailAccount = findViewById(R.id.about_email);
        TextView balanceAccount = findViewById(R.id.about_balance);
        Button aboutRegisterRenter = findViewById(R.id.aboutme_registerRenter);

        //Second Condition
        nameInput = findViewById(R.id.aboutme_name2);
        addressInput = findViewById(R.id.aboutme_address);
        phoneNumberInput = findViewById(R.id.aboutme_phoneNumber);
        Button aboutRegister = findViewById(R.id.aboutme_register);
        Button cancel = findViewById(R.id.aboutme_cancel);


        //Third Condition
        TextView nameRenter = findViewById(R.id.aboutme_textviewStore);
        TextView addressRenter = findViewById(R.id.aboutme_textviewPlace);
        TextView phoneNumberRenter = findViewById(R.id.aboutme_textviewNumber);
        dataCardView = findViewById(R.id.dataCardView);
        registerCardView = findViewById(R.id.registerCardView);

        nameAccount.setText(sessionAccount.name);
        emailAccount.setText(sessionAccount.email);
        balanceAccount.setText(Double.toString(sessionAccount.balance));
        registerCardView.setVisibility(View.INVISIBLE);
        dataCardView.setVisibility(View.INVISIBLE);

        mApiService = UtilsApi.getApiService();
        mContext = this;

        if (MainActivity.loginacc.renter == null) {
            dataCardView.setVisibility(View.INVISIBLE);
            registerCardView.setVisibility(View.INVISIBLE);
            aboutRegisterRenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    aboutRegisterRenter.setVisibility(View.INVISIBLE); //Button menghilang
                    registerCardView.setVisibility(View.VISIBLE);
                    dataCardView.setVisibility(View.INVISIBLE);
                    aboutRegister.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
//                            System.out.println(nameInput.getText().toString());
//                            System.out.println(addressInput.getText().toString());
//                            System.out.println(phoneNumberInput.getText().toString());
                            requestRenter();
                        }
                    });
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            aboutRegisterRenter.setVisibility(View.VISIBLE); //Button muncul
                            registerCardView.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            });
        }

        if(MainActivity.loginacc.renter != null){
            aboutRegisterRenter.setVisibility(View.INVISIBLE);
            registerCardView.setVisibility(View.INVISIBLE);
            dataCardView.setVisibility(View.VISIBLE);

            nameRenter.setText(MainActivity.loginacc.renter.username);
            addressRenter.setText(MainActivity.loginacc.renter.address);
            phoneNumberRenter.setText(String.valueOf(MainActivity.loginacc.renter.phoneNumber));
        }
    }

    protected Renter requestRenter(){
        mApiService.registerRenter(
                MainActivity.loginacc.id,
                nameInput.getText().toString(),
                addressInput.getText().toString(),
                phoneNumberInput.getText().toString()).enqueue(new Callback<Renter>() {
            @Override
            public void onResponse(Call<Renter> call, Response<Renter> response) {
                if(response.isSuccessful()){
                    MainActivity.loginacc.renter = response.body();
                    Intent move = new Intent(AboutMeActivity.this, MainActivity.class);
                    startActivity(move);
                    Toast.makeText(mContext, "Register Renter Successfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Renter> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(mContext, "Register Renter Failed", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }



}