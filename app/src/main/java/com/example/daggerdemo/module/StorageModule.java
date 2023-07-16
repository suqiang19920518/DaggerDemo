package com.example.daggerdemo.module;

import android.content.Context;

import com.example.daggerdemo.register.LoginStorage;
import com.example.daggerdemo.register.RegisterStorage;
import com.example.daggerdemo.register.SharedPreferencesStorage;
import com.example.daggerdemo.register.Storage;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class StorageModule {

    /**
     * SharedPreferencesStorage、RegisterStorage和 LoginStorage 都实现了 Storage，
     * 但是不能定义三个抽象函数去同时获得三个对象
     * 若要获得 RegisterStorage的实现类对象，只需要把bindStorage参数改成bindStorage(RegisterStorage storage)就行了
     * 若要获得 LoginStorage的实现类对象，只需要把bindStorage参数改成bindStorage(LoginStorage storage)就行了
     */
    //当Storage type被需要时，让 Dagger提供 SharedPreferencesStorage实例
    @Binds
    public abstract Storage bindStorage(SharedPreferencesStorage storage);

    // @Provides 不同于 @Binds注解，它可以在Module直接返回一个所需要类型的实例
    @Provides
    public static RegisterStorage provideRegisterStorage(Context context) {
        return new RegisterStorage(context, "register");
    }

    // @Provides 不同于 @Binds注解，它可以在Module直接返回一个所需要类型的实例
    @Provides
    public static LoginStorage provideLoginStorage(Context context) {
        return new LoginStorage(context, "login");
    }

}
