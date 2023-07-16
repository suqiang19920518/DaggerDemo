package com.example.daggerdemo.setting;

import com.example.daggerdemo.scope.LoginUserScope;

import javax.inject.Inject;

@LoginUserScope
public class SettingViewModel {

    @Inject
    public SettingViewModel(){}

}
