package com.example.daggerdemo.setting;

import com.example.daggerdemo.component.UserComponent;

import javax.inject.Inject;
import javax.inject.Singleton;

public class UserInfo {

    private UserComponent userComponent;
    private final UserComponent.Factory userComponentFactory;

    // 由于 UserInfo负责管理UserComponent的生命周期，它需要知道如何创建该对象，因此将factory传入
    @Inject
    public UserInfo(UserComponent.Factory userComponentFactory) {
        this.userComponentFactory = userComponentFactory;
    }

    public boolean isUserLogin() {
        return userComponent != null;
    }

    public void logout() {
        userComponent = null;
    }

    public void login() {
        userComponent = userComponentFactory.create();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

}
