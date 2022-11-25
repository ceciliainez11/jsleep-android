package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Renter;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.BaseApiService;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.request.UtilsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMeActivity extends AppCompatActivity {
    Context mContext;
    BaseApiService mApiService;

    TextView name, email, balance;

    Button RegistButton; Button RegistConfirm, RegistCancel;
    CardView RegistCard; CardView RenterCard; CardView RegisterAccCard;
    TextView NameAcc, NameAddress, PhoneNumber; TextView RenterNameFill, AddressFill, PhoneNumberFill;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        name = findViewById(R.id.nameAccount);
        email = findViewById(R.id.emailAccount);
        balance = findViewById(R.id.balanceAccount);

        if (balance == null)
        {
            balance.setText("0");
        }

        mApiService = UtilsApi.getApiService();
        mContext = this;

        name.setText(MainActivity.loginacc.name);
        email.setText(MainActivity.loginacc.email);
        balance.setText(String.valueOf(MainActivity.loginacc.balance));

        RegistButton = findViewById(R.id.registerRenterButton);

        RegistConfirm = findViewById(R.id.requestRegister);
        RegistCancel = findViewById(R.id.requestCancel);
        RenterCard = findViewById(R.id.CardViewRegister);



        NameAcc = findViewById(R.id.nameAboutMe);
        NameAddress = findViewById(R.id.addressAboutMe);
        PhoneNumber = findViewById(R.id.phoneNumberAboutMe);



        RegisterAccCard = findViewById(R.id.CardViewAccount);
        NameAcc = findViewById(R.id.NetlabStore);
        AddressFill = findViewById(R.id.GedungDte);

        PhoneNumberFill = findViewById(R.id.numberRegister);

        if (MainActivity.loginacc.renter == null)
        {
            RegistCard.setVisibility(CardView.VISIBLE);
            RegisterAccCard.setVisibility(CardView.GONE);
            RenterCard.setVisibility(CardView.GONE);


            RegistButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    RegistCard.setVisibility(CardView.GONE);
                    RenterCard.setVisibility(CardView.VISIBLE);
                    RegisterAccCard.setVisibility(CardView.GONE);

                    RegistConfirm.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Renter renter = requestRenter(MainActivity.loginacc.id, NameAcc.getText().toString(),
                                    NameAddress.getText().toString(), PhoneNumber.getText().toString());

                            Intent move = new Intent(AboutMeActivity.this, AboutMeActivity.class);
                            startActivity(move);
                        }

                    });
                    RegistCancel.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {

                            RenterCard.setVisibility(CardView.GONE);
                            RegisterAccCard.setVisibility(CardView.GONE);
                            RegistCard.setVisibility(CardView.VISIBLE);
                        }
                    });
                }
            });

        } else {
            RegistCard.setVisibility(CardView.GONE);
            RegisterAccCard.setVisibility(CardView.VISIBLE);
            RenterCard.setVisibility(CardView.GONE);

            RenterNameFill.setText(MainActivity.loginacc.renter.username);
            PhoneNumberFill.setText(MainActivity.loginacc.renter.address);
            AddressFill.setText(MainActivity.loginacc.renter.phoneNumber);
        }
    }

    protected Renter requestRenter(int id, String username, String address, String phone) {
        mApiService.registerRenter(id, username, address, phone).enqueue(new Callback<Renter>() {
            @Override

            public void onResponse(Call<Renter> call, Response<Renter> response) {

                if (response.isSuccessful()) {
                    Renter renter;
                    renter = response.body();
                    MainActivity.loginacc.renter = renter;
                    System.out.println("Renter Registered Success");
                    Toast.makeText(mContext, "Registered Renter", Toast.LENGTH_SHORT).show();

                }
            }



            @Override
            public void onFailure(Call<Renter> call, Throwable t) {
                Toast.makeText(mContext, "Failed to Register!", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }
}