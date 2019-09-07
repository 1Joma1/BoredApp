package com.geektech.infinityapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorage implements ISharedStorage {
    SharedPreferences sharedPreferences;

    public SharedStorage(Context context, String prefName) {
        sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Override
    public <T> void set(String key, T value) {
        if (value instanceof Integer){
            sharedPreferences.edit().putInt(key, (Integer) value).apply();
        } else if (value instanceof String){
            sharedPreferences.edit().putString(key, (String) value).apply();
        } else if (value instanceof Boolean){
            sharedPreferences.edit().putBoolean(key, (Boolean) value).apply();
        } else {
            //TODO: Add other types;
        }
    }

    @Override
    public <T> T get(String key, T defValue) {
        if (defValue instanceof Integer){
            return (T) Integer.valueOf(sharedPreferences.getInt(key, (Integer) defValue));
        } else if (defValue instanceof String){
            return (T) sharedPreferences.getString(key, (String) defValue);
        } else if (defValue instanceof Boolean){
            return (T) Boolean.valueOf(sharedPreferences.getBoolean(key, (Boolean) defValue));
        } else {
            return null;
            //TODO: Add other types;
        }
    }
}
