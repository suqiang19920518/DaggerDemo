package com.example.daggerdemo;

import android.app.Application;

import com.example.daggerdemo.component.ApplicationComponent;
import com.example.daggerdemo.component.DaggerApplicationComponent;

public class MyApplication extends Application {

    //创建一个全局属性，供应用的Activity调用
    public ApplicationComponent appComponent = DaggerApplicationComponent.factory().create(this);

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
