package com.androidteam.sellingthing.sellingthing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

@SuppressLint("Registered")
public class AuthenticationActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonSignInFb;
    Button buttonSignInGoogle;
    Button buttonSignIn;
    Button buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        buttonRegister = findViewById(R.id.auth_register);
        buttonSignIn = findViewById(R.id.auth_signin);
        buttonSignInFb = findViewById(R.id.auth_signin_fb);
        buttonSignInGoogle = findViewById(R.id.auth_signin_google);

        buttonSignInGoogle.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);
        buttonSignInFb.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.auth_register:
                Toast.makeText(this, "Register", Toast.LENGTH_SHORT).show();
                break;
            case R.id.auth_signin:
                startActivity(new Intent(AuthenticationActivity.this,LoginActivity.class));
                finish();
                break;
            case R.id.auth_signin_fb:
                Toast.makeText(this, "Sign In Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.auth_signin_google:
                /*




                 */
                break;

        }

    }
}
