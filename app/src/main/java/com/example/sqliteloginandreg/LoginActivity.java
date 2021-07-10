package com.example.sqliteloginandreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText l_pass,l_username;
    Button logBTN;
    TextView signupT;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        l_pass = findViewById(R.id.l_pass);
        l_username = findViewById(R.id.l_username);
        logBTN = findViewById(R.id.logBTN);
        signupT = findViewById(R.id.signupT);

        db = new DBHelper(this);

        signupT.setOnClickListener(this);
        logBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==signupT){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }if(v==logBTN){
            Login();
        }
    }
    public void Login(){
        String username = l_username.getText().toString();
        String password = l_pass.getText().toString();

        if(username.equals("")||password.equals("")){
            Toast.makeText(this, "Insert Parameters", Toast.LENGTH_SHORT).show();
        }else{
            Boolean checkuserpass = db.checkusernamepassword(username,password);
            if(checkuserpass==true){
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
}