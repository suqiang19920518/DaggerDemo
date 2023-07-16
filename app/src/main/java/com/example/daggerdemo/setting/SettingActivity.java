package com.example.daggerdemo.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.daggerdemo.MyApplication;
import com.example.daggerdemo.R;
import com.example.daggerdemo.bean.UserManager;

import javax.inject.Inject;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SettingActivity";

    @Inject
    SettingViewModel settingViewModel;

    private UserInfo userInfo;
    private Button mBtnSwitchLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userInfo = ((MyApplication) getApplication()).appComponent.userInfo();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mBtnSwitchLogin = findViewById(R.id.btn_switch_login);
        mBtnSwitchLogin.setOnClickListener(this);

        Log.e(TAG, "userInfo:" + userInfo.toString());
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_switch_login) {
            if (userInfo.isUserLogin()) {
                userInfo.logout();
                mBtnSwitchLogin.setText("login");
            } else {
                userInfo.login();
                mBtnSwitchLogin.setText("logout");
                //通过userInfo间接获取UserComponent对象
                userInfo.getUserComponent().inject(this);
                Log.e(TAG, "settingViewModel:" + settingViewModel.toString());
            }
        }
    }
}