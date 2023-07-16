package com.example.daggerdemo.register;

import com.example.daggerdemo.bean.UserManager;

import javax.inject.Inject;

public class RegisterViewModel {
    // @Inject 告诉Dagger如何提供 RegisterViewModel 对象
    // Dagger也知道 RegisterViewModel依赖了 UserManager
    @Inject
    public RegisterViewModel(UserManager userManager){}
}
