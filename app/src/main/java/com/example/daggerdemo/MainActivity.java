package com.example.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.daggerdemo.bean.FeedbackInfo;
import com.example.daggerdemo.bean.UserLocalDataSource;
import com.example.daggerdemo.bean.UserManager;
import com.example.daggerdemo.bean.UserRepository;
import com.example.daggerdemo.component.DaggerApplicationComponent;
import com.example.daggerdemo.login.LoginActivity;
import com.example.daggerdemo.qualifier.FeedQualifier1;
import com.example.daggerdemo.qualifier.FeedQualifier2;
import com.example.daggerdemo.register.LoginStorage;
import com.example.daggerdemo.register.RegisterActivity;
import com.example.daggerdemo.register.RegisterStorage;
import com.example.daggerdemo.setting.SettingActivity;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Retrofit retrofit;

    @Inject
    LoginRetrofitService loginRetrofitService;

    @Inject
    UserRepository userRepository;

    @Inject
    UserRepository userRepository2;

    @Inject
    UserLocalDataSource userLocalDataSource;

    @Inject
    UserLocalDataSource userLocalDataSource2;

    @Inject
    UserManager userManager;

    @Inject
    LoginStorage loginStorage;

    @Inject
    RegisterStorage registerStorage;

    // @Named("FeedbackInfo1")
    @FeedQualifier1
    @Inject
    FeedbackInfo feedbackInfo1;

    // @Named("FeedbackInfo2")
    @FeedQualifier2
    @Inject
    FeedbackInfo feedbackInfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //执行注入动作
        DaggerApplicationComponent.factory().create(this).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.btn_setting).setOnClickListener(this);

        Log.e(TAG, "retrofit:" + retrofit.toString());
        Log.e(TAG, "loginRetrofitService:" + loginRetrofitService.toString());
        Log.e(TAG, "userRepository:" + userRepository.toString());
        Log.e(TAG, "userRepository2:" + userRepository2.toString());
        Log.e(TAG, "userLocalDataSource:" + userLocalDataSource.toString());
        Log.e(TAG, "userLocalDataSource2:" + userLocalDataSource2.toString());
        Log.e(TAG, "userManager:" + userManager.toString() + "=========storage:" + userManager.getStorage().getName());
        Log.e(TAG, "loginStorage:" + loginStorage.getName());
        Log.e(TAG, "registerStorage:" + registerStorage.getName());
        Log.e(TAG, "feedbackInfo1:" + feedbackInfo1.getContent());
        Log.e(TAG, "feedbackInfo2:" + feedbackInfo2.getContent());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_login) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.btn_register) {
            startActivity(new Intent(this, RegisterActivity.class));
        } else if (id == R.id.btn_setting) {
            startActivity(new Intent(this, SettingActivity.class));
        }
    }
}