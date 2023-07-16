package com.example.daggerdemo.bean;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    //告诉Dagger如何提供UserRepository对象
    @Inject
    public UserRepository(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }

}
