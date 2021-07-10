package com.example.sqliteloginandreg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText l_pass,l_username;
    Button logBTN;
    TextView signupT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        l_pass = findViewById(R.id.l_pass);
        l_username = findViewById(R.id.l_username);
        logBTN = findViewById(R.id.logBTN);
        signupT = findViewById(R.id.signupT);

        signupT.setOnClickListener(this);
        logBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==signupT){

        }if(v==logBTN){

        }
    }
}