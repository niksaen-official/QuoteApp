package com.niksaen.testapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.niksaen.testapp.MainApplication;
import com.niksaen.testapp.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(((MainApplication)(getApplication())).getUserData().getIsNew())
            nextActivity(ChangeGenderActivity.class);
        else
            nextActivity(MainActivity.class);
    }
    private void nextActivity(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
        finish();
    }
}