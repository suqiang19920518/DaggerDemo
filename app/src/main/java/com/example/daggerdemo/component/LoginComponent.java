package com.example.daggerdemo.component;

import com.example.daggerdemo.login.LoginActivity;
import com.example.daggerdemo.login.LoginPasswordFragment;
import com.example.daggerdemo.login.LoginUsernameFragment;
import com.example.daggerdemo.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }

    //Dagger将会为 LoginActivity对象生成依赖对象，满足依赖关系
    void inject(LoginActivity loginActivity);
    void inject(LoginUsernameFragment loginUsernameFragment);
    void inject(LoginPasswordFragment loginPasswordFragment);
}
