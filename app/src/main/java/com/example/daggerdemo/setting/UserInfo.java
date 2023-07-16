package com.example.daggerdemo.setting;

import com.example.daggerdemo.component.UserComponent;

import javax.inject.Inject;
import javax.inject.Singleton;

public class UserInfo {

    private UserComponent userComponent;
    private final UserComponent.Factory userComponentFactory;

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
