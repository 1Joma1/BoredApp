package com.geektech.infinityapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.geektech.infinityapp.intro.IntroActivity;
import com.geektech.infinityapp.main.MainActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        redirect();
    }

    private void redirect(){
        if (App.appPreferences.isFirstLaunch()){
            App.appPreferences.setLaunched();
            IntroActivity.start(this);
        } else {
            MainActivity.start(this);
        }
        finish();
    }
}
