package com.RizkiAwantaJordhieJSleepKM.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.LoginActivity;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.R;
import com.CeciliaInezRevaJSleepRJ.jsleep_android.model.Account;

public class AboutMeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        Account sessionAccount = LoginActivity.loggedAccount;
        TextView nameAccount = findViewById(R.id.textView5);
        TextView emailAccount = findViewById(R.id.textView9);
        TextView balanceAccount = findViewById(R.id.textView11);

        nameAccount.setText(sessionAccount.name);
        emailAccount.setText(sessionAccount.email);
        balanceAccount.setText(Double.toString(sessionAccount.balance));


    }
}