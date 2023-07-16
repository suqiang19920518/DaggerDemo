package com.example.daggerdemo.component;

import com.example.daggerdemo.MainActivity;
import com.example.daggerdemo.setting.SettingActivity;
import com.example.daggerdemo.scope.LoginUserScope;

import dagger.Subcomponent;

@LoginUserScope
@Subcomponent
public interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        UserComponent create();
    }

    void inject(MainActivity mainActivity);
    void inject(SettingActivity settingActivity);
}
