package com.example.daggerdemo.bean;

import com.example.daggerdemo.component.UserComponent;
import com.example.daggerdemo.register.Storage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserManager {

    private final Storage storage;

    // @Inject 告诉Dagger如何提供 UserManager 对象
    // 由于 UserManager负责管理Storage的生命周期，它需要知道如何创建该对象，因此将Storage传入
    @Inject
    public UserManager(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

}
