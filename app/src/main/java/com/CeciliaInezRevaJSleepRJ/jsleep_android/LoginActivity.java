package com.CeciliaInezRevaJSleepRJ.jsleep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.CeciliaInezRevaJSleepRJ.jsleep_android.R.id;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent move = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(move);
            }
        });
        Button buttonLogin = findViewById(R.id.buttonRegister);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent move = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(move);
            }
        });
    }
}