package com.geektech.infinityapp;

import android.app.Application;

import com.geektech.infinityapp.data.BoredApiClient;
import com.geektech.infinityapp.utils.ISharedStorage;
import com.geektech.infinityapp.utils.SharedStorage;

public class App extends Application {

    public static ISharedStorage sharedStorage;
    public static AppPreferences appPreferences;
    public static BoredApiClient boredApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedStorage = new SharedStorage(this, "pref");
        appPreferences = new AppPreferences(sharedStorage);
        boredApiClient = new BoredApiClient();
    }
}
