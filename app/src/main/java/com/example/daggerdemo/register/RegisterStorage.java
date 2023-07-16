package com.example.daggerdemo.register;

import android.content.Context;

import javax.inject.Inject;

public class RegisterStorage implements Storage {
    String name;

    @Inject
    public RegisterStorage(Context context, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
