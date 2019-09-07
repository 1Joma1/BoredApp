package com.geektech.infinityapp.utils;

public interface ISharedStorage {

    <T> void set(String key, T value);

    <T> T get(String kry, T defValue);
}
