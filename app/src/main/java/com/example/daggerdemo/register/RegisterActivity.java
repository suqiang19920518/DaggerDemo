package com.example.daggerdemo.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.daggerdemo.MyApplication;
import com.example.daggerdemo.R;

import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getSimpleName();

    // @Inject 该字段将由Dagger提供实例
    @Inject
    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplication()).appComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Log.e(TAG, "registerViewModel:" + registerViewModel.toString());
    }
}