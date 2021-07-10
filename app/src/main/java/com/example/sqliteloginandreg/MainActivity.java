package com.example.sqliteloginandreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.LineNumberReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_username,pass,repass;
    TextView login;
    Button regBTN;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        regBTN = findViewById(R.id.regBTN);
        repass = findViewById(R.id.repass);

        db = new DBHelper(this);

        login.setOnClickListener(this);
        regBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==login){
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }if(v==regBTN){
            register();
        }
    }
    public void register(){
        String username = et_username.getText().toString();
        String password = pass.getText().toString();
        String repassword = repass.getText().toString();

        if(username.equals("") || password.equals("") || repassword.equals("")){
            Toast.makeText(this, "Insert the parameters", Toast.LENGTH_SHORT).show();
        }else{
            if(repassword.equals(password)){
                Boolean checkuser = db.checkusername(username);
                if(checkuser==false){
                    Boolean insert = db.insertData(username,password);
                    if(insert==true){
                        Toast.makeText(this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(this, "User Not Registered", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "User Already Exist", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "Password and confirm password not matching", Toast.LENGTH_SHORT).show();
            }
        }
    }
}