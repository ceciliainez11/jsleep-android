package com.CeciliaInezRevaJSleepRJ.jsleep_android;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

=======
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Renter;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.annotation.SuppressLint;
>>>>>>> 360a270 (Update Proyek Reva - UI)
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
import java.text.NumberFormat;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

<<<<<<< HEAD
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

=======
@SuppressLint("MissingInflatedId")
public class AboutMeActivity extends AppCompatActivity {
    BaseApiService mApiService;
    Context mContext;

    TextView aboutmeBalance, inputNominal;
    TextView out_name, out_address, out_phone;
    EditText am_input_name, am_input_address, am_input_phone;
    CardView registerCardView,dataCardView;
    Button buttonTopUp, ambuttonRegister, ambuttonCancel, buttonRegisterRenter;
//    Handler mHandler;

>>>>>>> 360a270 (Update Proyek Reva - UI)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

<<<<<<< HEAD
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
=======
        mApiService = UtilsApi.getApiService();
        mContext = this;

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        Account sessionAccount = MainActivity.loginacc;
        TextView nameAccount = findViewById(R.id.aboutmeName);
        TextView emailAccount = findViewById(R.id.aboutmeEmail);

        //First Condition
        buttonTopUp = findViewById(R.id.buttonTopUp);
        inputNominal = findViewById(R.id.inputNominal);
        aboutmeBalance = findViewById(R.id.aboutmeBalance);
        buttonRegisterRenter = findViewById(R.id.buttonRegisterRenter);


        //Second Condition
        am_input_name = findViewById(R.id.am_input_name);
        am_input_address = findViewById(R.id.am_input_address);
        am_input_phone = findViewById(R.id.am_input_phone);
        ambuttonRegister = findViewById(R.id.ambuttonRegister);
        ambuttonCancel = findViewById(R.id.ambuttonCancel);


        //Third Condition
        out_name = findViewById(R.id.out_name);
        out_address = findViewById(R.id.out_address);
        out_phone = findViewById(R.id.out_phone);
        dataCardView = findViewById(R.id.dataCardView);
        registerCardView = findViewById(R.id.registerCardView);

        nameAccount.setText(sessionAccount.name);
        emailAccount.setText(sessionAccount.email);
        aboutmeBalance.setText(Double.toString(sessionAccount.balance));

        String inputNominal = NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(sessionAccount.balance);
        aboutmeBalance.setText(inputNominal);

        buttonTopUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                topUpAccount();
            }
        });


        registerCardView.setVisibility(View.INVISIBLE);
        dataCardView.setVisibility(View.INVISIBLE);


        if (MainActivity.loginacc.renter == null) {
            dataCardView.setVisibility(View.INVISIBLE);
            registerCardView.setVisibility(View.INVISIBLE);
            buttonRegisterRenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonRegisterRenter.setVisibility(View.INVISIBLE);
                    dataCardView.setVisibility(View.INVISIBLE);
                    registerCardView.setVisibility(View.VISIBLE);
                    ambuttonRegister.setOnClickListener(new View.OnClickListener() {
>>>>>>> 360a270 (Update Proyek Reva - UI)
                        @Override
                        public void onClick(View view) {
//                            System.out.println(nameInput.getText().toString());
//                            System.out.println(addressInput.getText().toString());
//                            System.out.println(phoneNumberInput.getText().toString());
                            requestRenter();
                        }
                    });
<<<<<<< HEAD
                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            aboutRegisterRenter.setVisibility(View.VISIBLE); //Button muncul
=======

                    ambuttonCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            buttonRegisterRenter.setVisibility(View.VISIBLE); //Button muncul
>>>>>>> 360a270 (Update Proyek Reva - UI)
                            registerCardView.setVisibility(View.INVISIBLE);
                        }

                    });
                }
            });
        }

<<<<<<< HEAD
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
=======


        if(MainActivity.loginacc.renter != null){
            dataCardView.setVisibility(View.VISIBLE);
            buttonRegisterRenter.setVisibility(View.INVISIBLE);
            registerCardView.setVisibility(View.INVISIBLE);


            out_name.setText(MainActivity.loginacc.renter.username);
            out_address.setText(MainActivity.loginacc.renter.address);
            out_phone.setText(String.valueOf(MainActivity.loginacc.renter.phoneNumber));
        }
    }

    protected boolean topUpAccount() {
        mApiService.topUpRequest(
                MainActivity.loginacc.id,
                Double.parseDouble(inputNominal.getText().toString())
        ).enqueue(new Callback<Boolean>() {


            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                if (response.isSuccessful()) {
//                    topUp = response.body();
                    Toast.makeText(mContext, "Top Up Successful!", Toast.LENGTH_SHORT).show();
                    System.out.println(inputNominal.getText().toString());
                    aboutmeBalance.setText(NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(MainActivity.loginacc.balance + Double.parseDouble(inputNominal.getText().toString())));
//                    sessionAccount.balance+= Double.parseDouble(nominal.getText().toString());

                    MainActivity.loginacc.balance += Double.parseDouble(inputNominal.getText().toString());
                    inputNominal.setText("");
                }
            }


            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(mContext, "Top Up Failed!", Toast.LENGTH_SHORT).show();
>>>>>>> 360a270 (Update Proyek Reva - UI)
            }
        });
        return false;
    }

    protected Renter requestRenter(){
        mApiService.registerRenter(MainActivity.loginacc.id, am_input_name.getText().toString(),
                am_input_address.getText().toString(), am_input_phone.getText().toString()).enqueue(new Callback<Renter>() {


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