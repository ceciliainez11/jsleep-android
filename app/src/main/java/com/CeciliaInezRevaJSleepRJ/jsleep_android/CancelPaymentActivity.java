package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD

=======
>>>>>>> 360a270 (Update Proyek Reva - UI)
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.CeciliaInezRevaJSleepRJ.jsleep_android.BookingActivity;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.MainActivity;

public class CancelPaymentActivity extends AppCompatActivity {
    Context mContext;
    TextView returnAmount;
=======
public class CancelPaymentActivity extends AppCompatActivity {
    Context mContext;
    TextView cancelmoney;
>>>>>>> 360a270 (Update Proyek Reva - UI)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_payment);
<<<<<<< HEAD

        mContext = this;
=======
        mContext = this;


>>>>>>> 360a270 (Update Proyek Reva - UI)
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

<<<<<<< HEAD
        returnAmount = findViewById(R.id.cancel_price);
        returnAmount.setText(BookingActivity.priceCurrency);

        Toast.makeText(mContext, "Back To Main Menu in 5 Seconds", Toast.LENGTH_LONG).show();
=======

        cancelmoney = findViewById(R.id.cancelmoney);
        cancelmoney.setText(BookingActivity.priceCurrency);


        Toast.makeText(mContext, "Back To Menu. Wait for 5 Seconds", Toast.LENGTH_LONG).show();
>>>>>>> 360a270 (Update Proyek Reva - UI)
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent move = new Intent(CancelPaymentActivity.this, MainActivity.class);
                        startActivity(move);
                    }
                }, 5000);
    }
}