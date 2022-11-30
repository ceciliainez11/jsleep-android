package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMeActivity extends AppCompatActivity {
    Context mContext;
    BaseApiService mApiService;

    TextView name, email, balance;

    Button RegistButton, RegistConfirm, RegistCancel;

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

        //Second Condition
        EditText nameAccount = findViewById(R.id.nameAboutMe);
        EditText AddressAccount = findViewById(R.id.addressAboutMe);
        EditText PhoneNumberAccount = findViewById(R.id.phoneNumberAboutMe);
        RegistConfirm = findViewById(R.id.requestRegister);
        RegistCancel = findViewById(R.id.requestCancel);
        CardView CardViewRegister = findViewById(R.id.CardViewRegister);

        //Third Condition
        TextView InputName = findViewById(R.id.inputName);
        TextView InputAddress = findViewById(R.id.inputAddress);
        TextView InputPhone = findViewById(R.id.inputPhone);
        CardView CardViewAccount = findViewById(R.id.CardViewAccount);

        CardViewRegister.setVisibility(CardView.INVISIBLE);
        CardViewAccount.setVisibility(CardView.INVISIBLE);

        if (MainActivity.loginacc.renter == null)
        {
//            CardViewRegister.setVisibility(CardView.INVISIBLE);
//            CardViewAccount.setVisibility(CardView.INVISIBLE);

            RegistButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    RegistButton.setVisibility(Button.INVISIBLE);
                    CardViewRegister.setVisibility(CardView.VISIBLE);
                    CardViewAccount.setVisibility(CardView.INVISIBLE);

                    RegistConfirm.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view) {
                            Renter renter = requestRenter(MainActivity.loginacc.id, nameAccount.getText().toString(),
                                    AddressAccount.getText().toString(), PhoneNumberAccount.getText().toString());

//                            Intent move = new Intent(AboutMeActivity.this, AboutMeActivity.class);
//                            startActivity(move);
                        }

                    });
                    RegistCancel.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            CardViewRegister.setVisibility(CardView.INVISIBLE);
                            CardViewAccount.setVisibility(CardView.INVISIBLE);
                        }
                    });
                }
            });

        } else {
            RegistButton.setVisibility(Button.INVISIBLE);
            CardViewRegister.setVisibility(CardView.INVISIBLE);
            CardViewAccount.setVisibility(CardView.VISIBLE);

            InputName.setText(MainActivity.loginacc.renter.username);
            InputAddress.setText(MainActivity.loginacc.renter.address);
            InputPhone.setText(MainActivity.loginacc.renter.phoneNumber);
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
                    Intent move = new Intent(AboutMeActivity.this, AboutMeActivity.class);
                    startActivity(move);
                    Toast.makeText(mContext, "Registered Renter", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Renter> call, Throwable t) {
                System.out.println("GAGAL");
                Toast.makeText(mContext, "Failed to Register!", Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }
}