package com.androidteam.sellingthing.sellingthing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        delayToStartSignInActivity();
    }
    private void delayToStartSignInActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startSignInActivity();
                finishStartUpActivity();
            }
        }, 3000);


    }
    private void startSignInActivity(){
        Intent intent = new Intent(this,SignInActivity.class);
        startActivity(intent);

    }
    private void finishStartUpActivity(){finish();}
}
