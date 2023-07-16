package com.example.daggerdemo.login;

import com.example.daggerdemo.bean.UserRepository;
import com.example.daggerdemo.scope.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class LoginViewModel {
    private final UserRepository userRepository;

    //告诉Dagger如何提供LoginViewModel对象
    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
