package com.example.daggerdemo.component;

import android.content.Context;

import com.example.daggerdemo.MainActivity;
import com.example.daggerdemo.bean.UserManager;
import com.example.daggerdemo.module.FeedbackModule;
import com.example.daggerdemo.module.NetworkModule;
import com.example.daggerdemo.module.StorageModule;
import com.example.daggerdemo.module.SubComponentsModule;
import com.example.daggerdemo.register.RegisterActivity;
import com.example.daggerdemo.setting.UserInfo;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, StorageModule.class, FeedbackModule.class, SubComponentsModule.class})
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
    //Dagger将会为 RegistrationActivity对象生成依赖对象，满足依赖关系
    void inject(RegisterActivity registerActivity);

    //暴露图中的 LoginComponent.Factory
    LoginComponent.Factory loginComponent();

    //暴露UserManager给MainActivity和SettingsActivity访问
    UserInfo userInfo();

    @Component.Factory
    interface Factory {
        //使用 @BindInstance注解，被传入的context对象，在 ApplicationComponent中是可以获取到的
        ApplicationComponent create(@BindsInstance Context context);
    }
}
