package com.example.daggerdemo.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.daggerdemo.MyApplication;
import com.example.daggerdemo.R;
import com.example.daggerdemo.bean.User;
import com.example.daggerdemo.bean.UserManager;
import com.example.daggerdemo.component.LoginComponent;
import com.example.daggerdemo.component.UserComponent;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = LoginActivity.class.getSimpleName();

    LoginComponent loginComponent;
    LoginPasswordFragment loginPasswordFragment;
    LoginUsernameFragment loginUsernameFragment;
    private FragmentTransaction fragmentTransaction;

    //该字段将由Dagger提供实例
    @Inject
    LoginViewModel loginViewModel;

    @Inject
    LoginViewModel loginViewModel2;

    @Inject
    User user;

    @Inject
    User user2;

    @Inject
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loginComponent = ((MyApplication) getApplicationContext())
                .appComponent.loginComponent().create();
        //执行注入动作
        loginComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        Log.e(TAG, "user:" + user.toString());
        Log.e(TAG, "user2:" + user2.toString());
        Log.e(TAG, "LoginViewModel:" + loginViewModel.toString() + "==========UserRepository:" + loginViewModel.getUserRepository());
        Log.e(TAG, "LoginViewModel2:" + loginViewModel2.toString() + "==========UserRepository:" + loginViewModel2.getUserRepository());
    }

    private void initView() {
        findViewById(R.id.btn_show_password).setOnClickListener(this);
        findViewById(R.id.btn_show_username).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (id == R.id.btn_show_username) {
            if (loginPasswordFragment == null) {
                loginUsernameFragment = new LoginUsernameFragment();
            }
            fragmentTransaction.replace(R.id.fragment_container, loginUsernameFragment);
        } else if (id == R.id.btn_show_password) {
            if (loginPasswordFragment == null) {
                loginPasswordFragment = new LoginPasswordFragment();
            }
            fragmentTransaction.replace(R.id.fragment_container, loginPasswordFragment);
        }
        fragmentTransaction.commit();

    }

}