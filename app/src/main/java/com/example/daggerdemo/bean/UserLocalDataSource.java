package com.example.daggerdemo.bean;

import javax.inject.Inject;

public class UserLocalDataSource {

    //告诉Dagger如何提供UserLocalDataSource对象
    @Inject
    public UserLocalDataSource() {}

}
