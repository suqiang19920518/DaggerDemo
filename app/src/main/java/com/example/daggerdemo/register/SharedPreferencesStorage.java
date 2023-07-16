package com.example.daggerdemo.register;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class SharedPreferencesStorage implements Storage {

    @Inject
    public SharedPreferencesStorage(Context context) { }

    @Override
    public String getName() {
        return "SharedPreferences";
    }
}
