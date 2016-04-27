package com.example.rijul.javacoffee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rijul.javacoffee.MainActivity;
import com.example.rijul.javacoffee.R;


public class LoginActivity extends AppCompatActivity {

    EditText username,passwd;
    Button loginbtn,regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = username.getText().toString();
                saveCred(user, pass);
                redirecttomainactivity();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user1=username.getText().toString();
                String pass1=username.getText().toString();
                validateCreds(user1,pass1);


            }
        });
    }



    private void init() {


        username=(EditText)findViewById(R.id.username);
        passwd=(EditText)findViewById(R.id.password);


        loginbtn=(Button)findViewById(R.id.login_button);
        regbtn=(Button)findViewById(R.id.register_button);

    }


    private void validateCreds(String user1, String pass1) {
        SharedPreferences sharedPreferences =PreferenceManager.getDefaultSharedPreferences(this);//public
        String spUser=sharedPreferences.getString("username", "null");//default value is null if doesnt exist
        String spPass=sharedPreferences.getString("password","null");

        if(spUser.equals(user1)&& spPass.equals(pass1)){
            redirecttomainactivity();
        }
        else{
            showMessage("Invalid credentials!");
        }
    }
    private void showMessage(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }

    private void redirecttomainactivity() {

        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }



    private void saveCred(String user, String pass) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",user);
        editor.putString("password",pass);
        editor.apply();


    }
}

