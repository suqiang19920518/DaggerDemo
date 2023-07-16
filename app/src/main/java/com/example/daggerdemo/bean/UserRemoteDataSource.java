package com.example.daggerdemo.bean;

import com.example.daggerdemo.LoginRetrofitService;

import javax.inject.Inject;

public class UserRemoteDataSource {
    private LoginRetrofitService loginRetrofitService;

    //告诉Dagger如何提供UserRemoteDataSource对象
    @Inject
    public UserRemoteDataSource(LoginRetrofitService loginRetrofitService) {
        this.loginRetrofitService = loginRetrofitService;
    }

}
