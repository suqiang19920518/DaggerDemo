package com.example.daggerdemo.register;

import android.content.Context;

import javax.inject.Inject;

public class LoginStorage implements Storage {
    String name;

    @Inject
    public LoginStorage(Context context, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
