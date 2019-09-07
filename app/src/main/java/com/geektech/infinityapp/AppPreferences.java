package com.geektech.infinityapp;

import com.geektech.infinityapp.utils.ISharedStorage;

public class AppPreferences {

    private static final String PREF_IS_FIST_LAUNCH = "is_first_launch";

    private ISharedStorage sharedStorage;

    public AppPreferences(ISharedStorage sharedStorage){
        this.sharedStorage = sharedStorage;
    }

    boolean isFirstLaunch(){
        return sharedStorage.get(PREF_IS_FIST_LAUNCH, true);
    }

    void setLaunched(){
        sharedStorage.set(PREF_IS_FIST_LAUNCH, false);
    }
}
